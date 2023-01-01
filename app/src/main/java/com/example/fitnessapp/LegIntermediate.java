package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.VideoView;

public class LegIntermediate extends AppCompatActivity {

    VideoView vid, vid2, vid3, vid4, vid5,vid6,vid7,vid8,vid9,vid10,vid11,vid12,vid13,vid14;
    ScrollView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legintermediate);
        scView = findViewById(R.id.Scroll);
        scView.smoothScrollTo(0,0);

        String path = "android.resource://"+ getPackageName() +"/"+R.raw.sidehop;
        String path2 = "android.resource://"+ getPackageName() +"/"+R.raw.squats;
        String path3 = "android.resource://"+ getPackageName() +"/"+R.raw.sidelyingleft;
        String path4 = "android.resource://"+ getPackageName() +"/"+R.raw.sidelyingright;
        String path5 = "android.resource://"+ getPackageName() +"/"+R.raw.lunges;
        String path6 = "android.resource://"+ getPackageName() +"/"+R.raw.donkeykickleft;
        String path7 = "android.resource://"+ getPackageName() +"/"+R.raw.donkeykickright;
        String path8 = "android.resource://"+ getPackageName() +"/"+R.raw.wallcalf;

        vid = findViewById(R.id.sidehop);
        vid2 = findViewById(R.id.squat);
        vid3 = findViewById(R.id.squat2);
        vid4 = findViewById(R.id.leftsidelying);
        vid5 = findViewById(R.id.rightsidelying);
        vid6 = findViewById(R.id.leftsidelying2);
        vid7 = findViewById(R.id.rightsidelying2);
        vid8 = findViewById(R.id.lunges);
        vid9 = findViewById(R.id.lunges2);
        vid10 = findViewById(R.id.donkeyleft);
        vid11 = findViewById(R.id.donkeyright);
        vid12 = findViewById(R.id.donkeyleft2);
        vid13 = findViewById(R.id.donkeyright2);
        vid14 = findViewById(R.id.wallcalf);




        Uri uri = Uri.parse(path);
        Uri uri2 = Uri.parse(path2);
        Uri uri4 = Uri.parse(path3);
        Uri uri5 = Uri.parse(path4);
        Uri uri8 = Uri.parse(path5);
        Uri uri10 = Uri.parse(path6);
        Uri uri11 = Uri.parse(path7);
        Uri uri12 = Uri.parse(path8);

        vid.setVideoURI(uri);
        vid2.setVideoURI(uri2);
        vid3.setVideoURI(uri2);
        vid4.setVideoURI(uri4);
        vid5.setVideoURI(uri5);
        vid6.setVideoURI(uri4);
        vid7.setVideoURI(uri5);
        vid8.setVideoURI(uri8);
        vid9.setVideoURI(uri8);
        vid10.setVideoURI(uri10);
        vid11.setVideoURI(uri11);
        vid12.setVideoURI(uri10);
        vid13.setVideoURI(uri11);
        vid14.setVideoURI(uri12);



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
        vid5.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
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

        vid10.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid11.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid12.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid13.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        vid14.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
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
        vid11.start();
        vid12.start();
        vid13.start();
        vid14.start();

    }
}