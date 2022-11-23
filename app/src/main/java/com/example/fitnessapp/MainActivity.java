package com.example.fitnessapp;

import static com.example.fitnessapp.R.id.maleimg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton Male, Female;
    Button Next;
    ImageView MaleImg, FemaleImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Male = (RadioButton) findViewById(R.id.malebtn);
        Female = (RadioButton) findViewById(R.id.femalebtn);
        Next = (Button) findViewById(R.id.nextbtn);
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
                Female.setChecked(false);
                Next.setEnabled(true);
                break;

            case R.id.femaleimg:
                Male.setChecked(false);
                Next.setEnabled(true);
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.malebtn:
                if (checked) {
                    Female.setChecked(false);
                    Next.setEnabled(true);
                    break;
                } else {
                    Next.setEnabled(false);
                }

            case R.id.femalebtn:
                if (checked) {
                    Male.setChecked(false);
                    Next.setEnabled(true);
                    break;
                } else {
                    Next.setEnabled(false);
                }
            }
        }
}