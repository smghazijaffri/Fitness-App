package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {
    CardView FBody, LBody, ABegin, CBegin, ArmBegin, LBegin, SBegin, AbsInter, ChestInter, ArmInter, LegsInter, ShoulderInter, AbsAdv, ChestAdv, ArmAdv, LegsAdv, ShoulderAdv, Pedometer;
    Button SignOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FBody = findViewById(R.id.fullbody);
        LBody = findViewById(R.id.lowerbody);
        ABegin = findViewById(R.id.absbegin);
        CBegin = findViewById(R.id.chestbegin);
        ArmBegin = findViewById(R.id.armbegin);
        LBegin = findViewById(R.id.lbegin);
        SBegin = findViewById(R.id.shoulderbegin);
        AbsInter = findViewById(R.id.absinter);
        ChestInter = findViewById(R.id.chestinter);
        ArmInter = findViewById(R.id.armintermediate);
        LegsInter = findViewById(R.id.legintermediate);
        ShoulderInter = findViewById(R.id.shoulderinter);
        AbsAdv = findViewById(R.id.absadv);
        ChestAdv = findViewById(R.id.chestadv);
        ArmAdv = findViewById(R.id.armadv);
        LegsAdv = findViewById(R.id.legsadv);
        ShoulderAdv = findViewById(R.id.shoulderadv);
        Pedometer = findViewById(R.id.Pedo);
        SignOut = findViewById(R.id.signout);

        Intent intent = getIntent();
        intent.getExtras();

        if (intent.hasExtra("Logged In"))
        {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }

        FBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, fullbody.class));
            }
        });
        LBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, lowerbody.class));
            }
        });
        ABegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, absbeginner.class));
            }
        });
        CBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, chestbeginner.class));
            }
        });
        ArmBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, armbeginner.class));
            }
        });
        LBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, legsbeginner.class)); }
        });
        SBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, shoulderbeginner.class)); }
        });
        AbsInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, absintermediate.class)); }
        });
        ChestInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, chestintermediate.class)); }
        });
        ArmInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, armintermediate.class)); }
        });
        LegsInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, LegIntermediate.class)); }
        });
        ShoulderInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, ShoulderIntermediate.class)); }
        });
        AbsAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, absAdvanced.class)); }
        });
        ChestAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, chestAdvanced.class)); }
        });
        ArmAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, armAdvanced.class)); }
        });
        LegsAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, legAdvanced.class)); }
        });
        ShoulderAdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, ShoulderAdvanced.class)); }
        });
        Pedometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(home.this, Pedometer.class)); }
        });
        SignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(home.this, SignIn.class);
                String out = "Signed Out";
                intent.putExtra("Signed Out", out);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        /* super.onBackPressed(); */
    }
}