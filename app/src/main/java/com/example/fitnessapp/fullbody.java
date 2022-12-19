package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class fullbody extends AppCompatActivity {
VideoView vid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullbody);
        String path = "android.resource://"+ getPackageName() +"/"+R.raw.jumpingjack;
        vid = findViewById(R.id.jump);
        Uri uri = Uri.parse(path);
        vid.setVideoURI(uri);
        vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        vid.start();
    }
}