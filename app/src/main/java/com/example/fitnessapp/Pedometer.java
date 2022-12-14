package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Pedometer extends AppCompatActivity implements SensorEventListener {

    private int seconds = 0, user = 0;
    // Is the stopwatch running?
    private boolean running;
    private boolean wasRunning;
    Button button1, button2, button3, button4;
    private TextView textViewStepDetector, Timer;
    private SensorManager sensorManager;
    private Sensor mStepDetector;
    private Sensor stepDetectorSensor;
    private Sensor accelerometer;
    int stepDetected = 0;
    DatabaseHelper helper;
    private String uid;
    private FirebaseUser users;

    DatabaseReference databaseReference;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    String today = format.format(new Date());
    /*String uid;
    FirebaseUser data;*/

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            //Asks for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 100);
        }

        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            // if the activity has been
            // destroyed and recreated.
            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepDetector = findViewById(R.id.step_detector);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        Timer = findViewById(R.id.time_view);
        helper = new DatabaseHelper(Pedometer.this);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        }
        else{
            textViewStepDetector.setText("not presented");
        }
        onPause();

        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                onPause();
                running = false;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                onResume();
                running = true;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {

                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                String step, date = today, time;
                step = (textViewStepDetector.getText().toString().trim());
                time = (Timer.getText().toString().trim());
                int stepss = Integer.parseInt(step);

                databaseReference = FirebaseDatabase.getInstance().getReference();
                DataShanri shanri = new DataShanri(date, time, step);
                if (stepss <= 0){
                    Toast.makeText(Pedometer.this, "No steps to register", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("Pedometer").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(String.valueOf(System.currentTimeMillis())).setValue(shanri).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Pedometer.this, "Success", Toast.LENGTH_SHORT).show();
                                onPause();
                                textViewStepDetector.setText("0");
                                finish();
                                startActivity(getIntent());
                            } else {
                                Toast.makeText(Pedometer.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                Intent intent = new Intent(Pedometer.this, StepHistory.class);
                startActivity(intent);
                /*GetAllData();*/
            }
        });
        /*data = FirebaseAuth.getInstance().getCurrentUser();
        uid = data.getUid();*/
    }

    /*public void GetAllData() {
        final String[] data = {""};
        users = FirebaseAuth.getInstance().getCurrentUser();
        uid = users.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Pedometer").child(uid);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                AlertDialog.Builder build = new AlertDialog.Builder(Pedometer.this);
                data[0] = snapshot.getValue(DataShanri.class).toString();
                build.setTitle("Step History");
                build.setMessage(data[0]);
                build.show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AlertDialog.Builder build = new AlertDialog.Builder(Pedometer.this);
                *//*if (snapshot.exists()) {*//*
                    *//*if (snapshot.child("Pedometer").getValue() != null) {*//*
                        data[0] = snapshot.getValue(DataShanri.class).toString();
                        *//*data[0] = (String) snapshot.child("Pedometer").getValue().toString();*//*
*//*                    }*//*

                *//*}*//*
                build.setTitle("Step History");
                build.setMessage(data[0]);
                build.show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Pedometer.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    private void runTimer()
    {
        // Get the text view.
        final TextView timeView = (TextView)findViewById(R.id.time_view);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepDetector){
            stepDetected = (int) (stepDetected + sensorEvent.values[0]);
            textViewStepDetector.setText(String.valueOf(stepDetected));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null){
            sensorManager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_NORMAL);
            sensorManager.registerListener(this, stepDetectorSensor, SensorManager.SENSOR_DELAY_NORMAL);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        wasRunning = running;
        running = false;

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            sensorManager.unregisterListener(this, mStepDetector);
            sensorManager.unregisterListener(this, stepDetectorSensor);
            sensorManager.unregisterListener(this, accelerometer);
        }
    }
}