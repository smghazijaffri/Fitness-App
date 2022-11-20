 package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class PushUp extends AppCompatActivity {
     Button Next;
     CardView Begin, Inter, Adv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_up);
        Next = findViewById(R.id.btnpush);
        Begin = findViewById(R.id.beginner);
        Inter = findViewById(R.id.intermediate);
        Adv = findViewById(R.id.advanced);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushUp.this, Activity.class);
                startActivity(intent);
            }
        });
        Begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Begin.setBackgroundResource(android.R.color.darker_gray);
                Inter.setBackgroundResource(R.color.white);
                Adv.setBackgroundResource(R.color.white);
            }
        });
        Inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Inter.setBackgroundResource(android.R.color.darker_gray);
                Begin.setBackgroundResource(R.color.white);
                Adv.setBackgroundResource(R.color.white);
            }
        });
        Adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Adv.setBackgroundResource(android.R.color.darker_gray);
                Begin.setBackgroundResource(R.color.white);
                Inter.setBackgroundResource(R.color.white);
            }
        });
    }
}