package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Motivation extends AppCompatActivity {
    Button Next;
    CardView Confident, Stress, Health, Energy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);
        Next = findViewById(R.id.btnmov);
        Confident = findViewById(R.id.fc);
        Stress = findViewById(R.id.rs);
        Health = findViewById(R.id.ih);
        Energy = findViewById(R.id.be);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Motivation.this, PushUp.class);
                startActivity(intent);
            }
        });
        Confident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Confident.setBackgroundResource(android.R.color.darker_gray);
                Stress.setBackgroundResource(R.color.white);
                Health.setBackgroundResource(R.color.white);
                Energy.setBackgroundResource(R.color.white);
            }
        });
        Stress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Stress.setBackgroundResource(android.R.color.darker_gray);
                Confident.setBackgroundResource(R.color.white);
                Health.setBackgroundResource(R.color.white);
                Energy.setBackgroundResource(R.color.white);
            }
        });
        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Health.setBackgroundResource(android.R.color.darker_gray);
                Stress.setBackgroundResource(R.color.white);
                Confident.setBackgroundResource(R.color.white);
                Energy.setBackgroundResource(R.color.white);
            }
        });
        Energy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Energy.setBackgroundResource(android.R.color.darker_gray);
                Stress.setBackgroundResource(R.color.white);
                Health.setBackgroundResource(R.color.white);
                Confident.setBackgroundResource(R.color.white);
            }
        });
    }
}