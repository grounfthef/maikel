package com.wposs.androidya;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Reproducciondeaudio extends AppCompatActivity {
MediaPlayer mp,mp1;
Button b5;
int posicion=0;
int posicion1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reproducciondeaudio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void stressedou(View view){
        mp = MediaPlayer.create(this,R.raw.stressedout);
        mp.start();
    }
    public void pausar1(View view){
        if (mp!=null&& mp.isPlaying()){
            posicion=mp.getCurrentPosition();
            mp.pause();
        }
    }
    public void continuar1(View view){
        if (mp!=null&& mp.isPlaying()==false){
            mp.seekTo(posicion);
            mp.start();
        }
    }
    public void detener1(View view){
        if(mp!=null&& mp.isPlaying()){
            mp.stop();
            posicion=0;
            mp.prepareAsync();
        }
    }
    public void Money (View view){
        mp1 = MediaPlayer.create(this,R.raw.money);
        mp1.start();
    }
    public void pausar2(View view){
        if (mp1!=null&& mp1.isPlaying()){
            posicion1=mp1.getCurrentPosition();
            mp1.pause();
        }
    }
    public void continuar2(View view){
        if(mp1!=null&& mp1.isPlaying()==false){
            mp1.seekTo(posicion1);
            mp1.start();
        }
    }
    public void detener2(View view){
        if (mp1!=null&&mp1.isPlaying()){
            mp1.stop();
            posicion1=0;
            mp1.prepareAsync();
        }
    }
}