package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

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

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChild("Pedometer")){
                    user = (int) snapshot.child("Pedometer").getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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
            @Override
            public void onClick(View v) {
                onPause();
                running = false;
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
                running = true;
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int step, date;
                String time;
                step = Integer.parseInt(textViewStepDetector.getText().toString().trim());
                time = (Timer.getText().toString().trim());
                *//*date = today.trim();*//*

                if (step <= 0){
                    Toast.makeText(Pedometer.this, "No steps to register", Toast.LENGTH_SHORT).show();
                }
                else{
                    onPause();
                    textViewStepDetector.setText("0");
                    helper.InsertSteps(time, step);
                    finish();
                    startActivity(getIntent());
                }*/
                String step, date;
                String time;
                step = (textViewStepDetector.getText().toString().trim());
                time = (Timer.getText().toString().trim());
                int stepss = Integer.parseInt(step);

                DataShanri shanri = new DataShanri(time, step);
                if (stepss <= 0){
                    Toast.makeText(Pedometer.this, "No steps to register", Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("Pedometer").child(String.valueOf(user + 1)).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(shanri).addOnCompleteListener(new OnCompleteListener<Void>() {
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
            @Override
            public void onClick(View v) {
                GetAllData();
            }
        });
    }

    public void GetAllData() {
        final String[] data = {""};
        /*Cursor cursor = helper.GetDataCursor();
        while (cursor.moveToNext()) {
            data = data + "Duration: " + cursor.getString(1) + " ";
            data = data + "Steps: " + cursor.getString(2) + "\n";

        }
        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
        build.setTitle("All Data");
        build.setMessage(data);
        build.show();*/
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                AlertDialog.Builder build = new AlertDialog.Builder(Pedometer.this);
                if (snapshot.exists()) {
                    if (snapshot.child("Pedometer").getValue() != null) {
                        data[0] = snapshot.child("Pedometer").getValue().toString();
                    }
                }
                build.setTitle("Step History");
                build.setMessage(data[0]);
                build.show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Pedometer.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

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