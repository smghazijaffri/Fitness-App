package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity extends AppCompatActivity {
    Button Next;
    CardView Seden, Lightly, Mode, Active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        Next = findViewById(R.id.btnact);
        Seden = findViewById(R.id.sed);
        Lightly = findViewById(R.id.light);
        Mode = findViewById(R.id.mod);
        Active = findViewById(R.id.active);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity.this, Weekly.class);
                startActivity(intent);
            }
        });
        Seden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Seden.setBackgroundResource(android.R.color.darker_gray);
                Lightly.setBackgroundResource(R.color.white);
                Mode.setBackgroundResource(R.color.white);
                Active.setBackgroundResource(R.color.white);
            }
        });
        Lightly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Lightly.setBackgroundResource(android.R.color.darker_gray);
                Mode.setBackgroundResource(R.color.white);
                Active.setBackgroundResource(R.color.white);
                Seden.setBackgroundResource(R.color.white);
            }
        });
        Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Mode.setBackgroundResource(android.R.color.darker_gray);
                Lightly.setBackgroundResource(R.color.white);
                Seden.setBackgroundResource(R.color.white);
                Active.setBackgroundResource(R.color.white);
            }
        });
        Active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Active.setBackgroundResource(android.R.color.darker_gray);
                Seden.setBackgroundResource(R.color.white);
                Lightly.setBackgroundResource(R.color.white);
                Mode.setBackgroundResource(R.color.white);
            }
        });
    }
}