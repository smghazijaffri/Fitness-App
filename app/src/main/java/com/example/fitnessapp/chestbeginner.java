package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class chestbeginner extends AppCompatActivity {
    VideoView vid, vid2, vid3, vid4, vid5,vid6,vid7,vid8,vid9,vid10,vid11,vid12,vid13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestbeginner);
        String path = "android.resource://"+ getPackageName() +"/"+R.raw.jumpingjack;
        String path2 = "android.resource://"+ getPackageName() +"/"+R.raw.inclinepushup;
        String path3 = "android.resource://"+ getPackageName() +"/"+R.raw.pushup;
        String path4 = "android.resource://"+ getPackageName() +"/"+R.raw.widepushup;
        String path5 = "android.resource://"+ getPackageName() +"/"+R.raw.kneepushup;
        String path6 = "android.resource://"+ getPackageName() +"/"+R.raw.cobrastretch;
        String path7 = "android.resource://"+ getPackageName() +"/"+R.raw.tricepdips;
        vid = findViewById(R.id.jump);
        vid2 = findViewById(R.id.inpush);
        vid3 = findViewById(R.id.push);
        vid4 = findViewById(R.id.widepush);
        vid5 = findViewById(R.id.kneepush);
        vid6 = findViewById(R.id.cobra);
        vid7 = findViewById(R.id.inpush2);
        vid7 = findViewById(R.id.tricepdips);
        vid9 = findViewById(R.id.widepush2);
        vid10 = findViewById(R.id.tricepdips2);


        Uri uri = Uri.parse(path);
        Uri uri2 = Uri.parse(path2);
        Uri uri3 = Uri.parse(path3);
        Uri uri4 = Uri.parse(path4);
        Uri uri5 = Uri.parse(path5);
        Uri uri6 = Uri.parse(path6);
        Uri uri7 = Uri.parse(path7);
        vid.setVideoURI(uri);
        vid2.setVideoURI(uri2);
        vid3.setVideoURI(uri3);
        vid4.setVideoURI(uri4);
        vid5.setVideoURI(uri5);
        vid6.setVideoURI(uri6);
        vid7.setVideoURI(uri2);
        vid8.setVideoURI(uri3);
        vid9.setVideoURI(uri7);
        vid10.setVideoURI(uri7);
        vid.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        vid6.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid7.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid8.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid9.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid10.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid.start();
        vid2.start();
        vid3.start();
        vid4.start();
        vid5.start();
        vid6.start();
        vid7.start();
        vid8.start();
        vid9.start();
        vid10.start();
    }
}