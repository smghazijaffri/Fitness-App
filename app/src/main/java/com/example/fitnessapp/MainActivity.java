package com.example.fitnessapp;

import static com.example.fitnessapp.R.id.maleimg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView Male, Female;
    Button Next;
    ImageView MaleImg, FemaleImg;
    LinearLayout BG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Male = findViewById(R.id.malebtn);
        Female = findViewById(R.id.femalebtn);
        Next = (Button) findViewById(R.id.nextbtn);
        MaleImg = findViewById(maleimg);
        FemaleImg = findViewById(R.id.femaleimg);
        BG = findViewById(R.id.bg);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, focus.class));
            }
        });
    }

    public void onImageClicked(View view) {
        switch (view.getId()) {
            case maleimg:
                Next.setEnabled(true);
                BG.setBackgroundResource(android.R.color.holo_blue_light);
                break;

            case R.id.femaleimg:
                Next.setEnabled(true);
                BG.setBackgroundResource(android.R.color.holo_red_light);
                break;
        }
    }
}