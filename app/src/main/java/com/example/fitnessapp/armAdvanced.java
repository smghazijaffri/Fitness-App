package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.VideoView;

public class armAdvanced extends AppCompatActivity {
    VideoView vid, vid2, vid3, vid4, vid5,vid6,vid7,vid8,vid9,vid10,vid11,vid12,vid13,vid14;
    ScrollView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_advanced);
        scView = findViewById(R.id.Scroll);
        scView.smoothScrollTo(0,0);

        String path = "android.resource://"+ getPackageName() +"/"+R.raw.sidearmraise;
        String path2 = "android.resource://"+ getPackageName() +"/"+R.raw.tricepdips;
        String path3 = "android.resource://"+ getPackageName() +"/"+R.raw.armcircleclock;
        String path4 = "android.resource://"+ getPackageName() +"/"+R.raw.armcircleanticlock;
        String path5 = "android.resource://"+ getPackageName() +"/"+R.raw.diamondpushup;
        String path6 = "android.resource://"+ getPackageName() +"/"+R.raw.jumpingjack;
        String path7 = "android.resource://"+ getPackageName() +"/"+R.raw.chestpresspulse;
        String path8 = "android.resource://"+ getPackageName() +"/"+R.raw.legbarbellleft;
        String path9 = "android.resource://"+ getPackageName() +"/"+R.raw.legbarbellright;
        String path10 = "android.resource://"+ getPackageName() +"/"+R.raw.diagonalplank;
        String path11 = "android.resource://"+ getPackageName() +"/"+R.raw.punches;
        String path12 = "android.resource://"+ getPackageName() +"/"+R.raw.pushup;
        String path13 = "android.resource://"+ getPackageName() +"/"+R.raw.inchworms;
        String path14 = "android.resource://"+ getPackageName() +"/"+R.raw.wallpushup;



        vid = findViewById(R.id.sidearmraise);
        vid2 = findViewById(R.id.tricepdips);
        vid3 = findViewById(R.id.armcircleclock);
        vid4 = findViewById(R.id.armcircleanclock);
        vid5 = findViewById(R.id.diamondpushup);
        vid6 = findViewById(R.id.jump);
        vid7 = findViewById(R.id.chestpresspulse);
        vid8 = findViewById(R.id.legabarbellcurlleft);
        vid9 = findViewById(R.id.legabarbellcurlright);
        vid10 = findViewById(R.id.diagnolplank);
        vid11 = findViewById(R.id.punches);

        vid13 = findViewById(R.id.inchworms);
        vid14 = findViewById(R.id.wallpush);





        Uri uri = Uri.parse(path);
        Uri uri2 = Uri.parse(path2);
        Uri uri3 = Uri.parse(path3);
        Uri uri4 = Uri.parse(path4);
        Uri uri5 = Uri.parse(path5);
        Uri uri6 = Uri.parse(path6);
        Uri uri7 = Uri.parse(path7);
        Uri uri8 = Uri.parse(path8);
        Uri uri9 = Uri.parse(path9);
        Uri uri10 = Uri.parse(path10);
        Uri uri11 = Uri.parse(path11);
        Uri uri12 = Uri.parse(path12);
        Uri uri13 = Uri.parse(path13);
        Uri uri14 = Uri.parse(path14);


        vid.setVideoURI(uri);
        vid2.setVideoURI(uri2);
        vid3.setVideoURI(uri3);
        vid4.setVideoURI(uri4);
        vid5.setVideoURI(uri5);
        vid6.setVideoURI(uri6);
        vid7.setVideoURI(uri7);
        vid8.setVideoURI(uri8);
        vid9.setVideoURI(uri9);
        vid10.setVideoURI(uri10);
        vid11.setVideoURI(uri11);

        vid13.setVideoURI(uri13);
        vid14.setVideoURI(uri14);




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
        vid11.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
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

        vid13.start();
        vid14.start();

    }
}