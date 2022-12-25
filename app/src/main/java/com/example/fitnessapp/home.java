package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {
    CardView FBody, LBody, ABegin, CBegin, ArmBegin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FBody = findViewById(R.id.fullbody);
        LBody = findViewById(R.id.lowerbody);
        ABegin = findViewById(R.id.absbegin);
        CBegin = findViewById(R.id.chestbegin);
        ArmBegin = findViewById(R.id.armbegin);

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
    }
}