package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton Male, Female;
    Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Male = (RadioButton)findViewById(R.id.malebtn);
        Female = (RadioButton)findViewById(R.id.femalebtn);
        Next = (Button)findViewById(R.id.nextbtn);
    }

    public void onRadioButtonClicked(View view)
    {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.malebtn:
                if (checked) {
                    Female.setChecked(false);
                    Next.setEnabled(true);
                    break;
                }
                else{
                    Next.setEnabled(false);
                }
            case R.id.femalebtn:
                if (checked) {
                    Male.setChecked(false);
                    Next.setEnabled(true);
                    break;
                }
                else{
                    Next.setEnabled(false);
                }
        }
    }
}