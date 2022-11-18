package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Goal extends AppCompatActivity {
    Button Next;
    CardView Lose, Build, Keep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        Next = (Button) findViewById(R.id.btngoal);
        Lose = findViewById(R.id.lw);
        Build = findViewById(R.id.bm);
        Keep = findViewById(R.id.kf);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Goal.this, Motivation.class);
                startActivity(intent);
            }
        });
        Lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Lose.setBackgroundResource(android.R.color.darker_gray);
                Keep.setBackgroundResource(R.color.white);
                Build.setBackgroundResource(R.color.white);
            }
        });
        Build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Next.setEnabled(true);
                Build.setBackgroundResource(android.R.color.darker_gray);
                Keep.setBackgroundResource(R.color.white);
                Lose.setBackgroundResource(R.color.white);
            }
        });
        Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Keep.setBackgroundResource(android.R.color.darker_gray);
                Lose.setBackgroundResource(R.color.white);
                Build.setBackgroundResource(R.color.white);
            }
        });
    }
}