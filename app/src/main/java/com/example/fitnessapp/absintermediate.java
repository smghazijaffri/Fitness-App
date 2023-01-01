package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class absintermediate extends AppCompatActivity {
    VideoView vid, vid2, vid3, vid4, vid5,vid6,vid7,vid8,vid9,vid10,vid11,vid12,vid13,vid14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absintermediate);

        String path = "android.resource://"+ getPackageName() +"/"+R.raw.jumpingjack;
        String path2 = "android.resource://"+ getPackageName() +"/"+R.raw.crossovercrunch;
        String path3 = "android.resource://"+ getPackageName() +"/"+R.raw.sidebridgeleft;
        String path4 = "android.resource://"+ getPackageName() +"/"+R.raw.mountainclimber;
        String path5 = "android.resource://"+ getPackageName() +"/"+R.raw.sidebridgeright;
        String path6 = "android.resource://"+ getPackageName() +"/"+R.raw.buttbridge;
        String path7 = "android.resource://"+ getPackageName() +"/"+R.raw.bicyclecrunch;
        String path8 = "android.resource://"+ getPackageName() +"/"+R.raw.abdominalcrunches;
        String path9 = "android.resource://"+ getPackageName() +"/"+R.raw.legraises;
        String path10 = "android.resource://"+ getPackageName() +"/"+R.raw.pushuprotation;



        vid = findViewById(R.id.jump);
        vid2 = findViewById(R.id.crossover);
        vid3 = findViewById(R.id.bridgeleft);
        vid4 = findViewById(R.id.mountainclimeber);
        vid5 = findViewById(R.id.bridgeright);
        vid6 = findViewById(R.id.buttbridge);
        vid7 = findViewById(R.id.bicyclecrunches);
        vid8 = findViewById(R.id.abdominal);
        vid9 = findViewById(R.id.crossover2);
        vid10 = findViewById(R.id.legraises);
        vid11 = findViewById(R.id.bicyclecrunches2);
        vid12 = findViewById(R.id.pushandrotate);





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


        vid.setVideoURI(uri);
        vid2.setVideoURI(uri2);
        vid3.setVideoURI(uri3);
        vid4.setVideoURI(uri4);
        vid5.setVideoURI(uri5);
        vid6.setVideoURI(uri6);
        vid7.setVideoURI(uri7);
        vid8.setVideoURI(uri8);
        vid9.setVideoURI(uri2);
        vid10.setVideoURI(uri9);
        vid11.setVideoURI(uri7);
        vid12.setVideoURI(uri10);





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
        vid12.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
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

    }
}