package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Body extends AppCompatActivity {

    EditText Weight, Height;
    Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        Next = findViewById(R.id.btnbod);
        Weight = findViewById(R.id.wei);
        Height = findViewById(R.id.hei);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enable();
            }
        });
    }
    public void Enable(){
        String Weig = (Weight.getText().toString().trim());
        String Heig = (Height.getText().toString().trim());
        if (Weig.isEmpty()){
            Weight.setError("Field is Empty");
        }
        else if (Heig.isEmpty()){
            Height.setError("Field is Empty");
        }
        else {
            Intent intent = new Intent(Body.this, Body.class);
            startActivity(intent);
        }
    }
}