package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        else if (Integer.parseInt(Weig) <= 40){
            Weight.setError("Error");
            Toast.makeText(Body.this,"Weight is too low for any program",Toast.LENGTH_SHORT).show();
        }
        else if (Float.parseFloat(Heig) < 3 || Float.parseFloat(Heig) > 7){
            Height.setError("Error");
            Toast.makeText(Body.this,"No program available for such height",Toast.LENGTH_SHORT).show();
        }

        else {
            startActivity(new Intent(Body.this, SignIn.class));
        }
    }
}