package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {
    CardView FBody, LBody, ABegin, CBegin, ArmBegin, LBegin, SBegin, AbsInter, ChestInter, ArmInter, LegsInter, ShoulderInter, AbsAdv, ChestAdv, ArmAdv, LegsAdv, ShoulderAdv;
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
    }
}