package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Weekly extends AppCompatActivity {
    Button Next;
    CardView One, Two, Three, Four, Five, Six, Seven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        Next = findViewById(R.id.btnweek);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Weekly.this, Body.class);
                startActivity(intent);
            }
        });
        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                One.setBackgroundResource(android.R.color.darker_gray);
                Two.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Two.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Three.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Two.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Four.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Two.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Five.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Two.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Six.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Two.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Seven.setBackgroundResource(R.color.white);
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Seven.setBackgroundResource(android.R.color.darker_gray);
                One.setBackgroundResource(R.color.white);
                Two.setBackgroundResource(R.color.white);
                Three.setBackgroundResource(R.color.white);
                Four.setBackgroundResource(R.color.white);
                Five.setBackgroundResource(R.color.white);
                Six.setBackgroundResource(R.color.white);
            }
        });


    }
}