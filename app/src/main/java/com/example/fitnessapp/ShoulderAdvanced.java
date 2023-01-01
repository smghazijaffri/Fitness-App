package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.VideoView;

public class ShoulderAdvanced extends AppCompatActivity {
    VideoView vid, vid2, vid3, vid4, vid5,vid6,vid7,vid8,vid9,vid10,vid11,vid12,vid13,vid14;
    ScrollView scView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulderadvanced);
        scView = findViewById(R.id.Scroll);
        scView.smoothScrollTo(0,0);

        String path = "android.resource://"+ getPackageName() +"/"+R.raw.jumpingjack;
        String path2 = "android.resource://"+ getPackageName() +"/"+R.raw.rhomboidpulls;
        String path3 = "android.resource://"+ getPackageName() +"/"+R.raw.sidearmraise;
        String path4 = "android.resource://"+ getPackageName() +"/"+R.raw.kneepushup;
        String path5 = "android.resource://"+ getPackageName() +"/"+R.raw.armscissor;
        String path6 = "android.resource://"+ getPackageName() +"/"+R.raw.catcow;
        String path7 = "android.resource://"+ getPackageName() +"/"+R.raw.pronetricep;
        String path8 = "android.resource://"+ getPackageName() +"/"+R.raw.reclinedrhomboid;



        vid = findViewById(R.id.jump);
        vid2 = findViewById(R.id.rhomboidpulls);
        vid3 = findViewById(R.id.sidearmraise);
        vid4 = findViewById(R.id.kneepushup);
        vid5 = findViewById(R.id.armscissors);
        vid6 = findViewById(R.id.rhomboidpulls2);
        vid7 = findViewById(R.id.sidearmraise2);
        vid8 = findViewById(R.id.kneepushup2);
        vid9 = findViewById(R.id.catcow);
        vid10 = findViewById(R.id.pronetriceppushups);
        vid11 = findViewById(R.id.reclinedrhomboidsqueezes);
        vid12 = findViewById(R.id.pronetriceppushups2);
        vid13 = findViewById(R.id.reclinedrhomboidsqueezes2);







        Uri uri = Uri.parse(path);
        Uri uri2 = Uri.parse(path2);
        Uri uri3 = Uri.parse(path3);
        Uri uri4 = Uri.parse(path4);
        Uri uri5 = Uri.parse(path5);
        Uri uri6 = Uri.parse(path6);
        Uri uri7 = Uri.parse(path7);
        Uri uri8 = Uri.parse(path8);


        vid.setVideoURI(uri);
        vid2.setVideoURI(uri2);
        vid3.setVideoURI(uri3);
        vid4.setVideoURI(uri4);
        vid5.setVideoURI(uri5);
        vid6.setVideoURI(uri2);
        vid7.setVideoURI(uri3);
        vid8.setVideoURI(uri4);
        vid9.setVideoURI(uri6);
        vid10.setVideoURI(uri7);
        vid11.setVideoURI(uri8);
        vid12.setVideoURI(uri7);
        vid13.setVideoURI(uri8);




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
        vid13.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
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

    }
}