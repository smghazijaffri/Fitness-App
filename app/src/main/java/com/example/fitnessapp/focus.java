package com.example.fitnessapp;

import static com.example.fitnessapp.R.color.black;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.RoundedCorner;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class focus extends AppCompatActivity {
    Button Next;
    CardView Body, Arm, Chest, Legs, Abs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
        Next = (Button) findViewById(R.id.btnfocus);
        Body = (CardView) findViewById(R.id.fb);
        Arm = (CardView) findViewById(R.id.arm);
        Chest = (CardView) findViewById(R.id.chest);
        Legs = (CardView) findViewById(R.id.legs);
        Abs = (CardView) findViewById(R.id.abs);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(focus.this, Goal.class);
                startActivity(intent);
            }
        });
        Body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Body.setBackgroundResource(android.R.color.darker_gray);
                Legs.setBackgroundResource(R.color.white);
                Arm.setBackgroundResource(R.color.white);
                Abs.setBackgroundResource(R.color.white);
                Chest.setBackgroundResource(R.color.white);
            }
        });
        Legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Legs.setBackgroundResource(android.R.color.darker_gray);
                Body.setBackgroundResource(R.color.white);
                Abs.setBackgroundResource(R.color.white);
                Chest.setBackgroundResource(R.color.white);
                Arm.setBackgroundResource(R.color.white);
            }
        });
        Abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Abs.setBackgroundResource(android.R.color.darker_gray);
                Body.setBackgroundResource(R.color.white);
                Legs.setBackgroundResource(R.color.white);
                Arm.setBackgroundResource(R.color.white);
                Chest.setBackgroundResource(R.color.white);
            }
        });
        Arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Arm.setBackgroundResource(android.R.color.darker_gray);
                Body.setBackgroundResource(R.color.white);
                Abs.setBackgroundResource(R.color.white);
                Chest.setBackgroundResource(R.color.white);
                Legs.setBackgroundResource(R.color.white);
            }
        });
        Chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next.setEnabled(true);
                Chest.setBackgroundResource(android.R.color.darker_gray);
                Legs.setBackgroundResource(R.color.white);
                Arm.setBackgroundResource(R.color.white);
                Body.setBackgroundResource(R.color.white);
                Abs.setBackgroundResource(R.color.white);
            }
        });
    }


}