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
MediaPlayer mp;
Button b5;
int posicion=0;
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
        b5=findViewById(R.id.button5);
    }
    public void destruir(){
        if(mp!=null)
            mp.release();
    }
    public void stressedou(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.stressedout);
        mp.start();
    }
    public void pausar1(View view){
        if (mp!=null&& mp.isLooping()){
            posicion=mp.getAudioSessionId();
            mp.pause();
        }
    }
    public void continuar1(View view){
        if (mp!=null&& mp.isLooping()==false){
            mp.seekTo((posicion));
            mp.start();
        }
    }
    public void detener1(View view){
        if(mp!=null){
            mp.stop();
            posicion=0;
        }
    }
    public void Money (View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.money);
        mp.start();
    }
    public void pausar2(View view){
        if (mp!=null&& mp.isLooping()){
            posicion=mp.getAudioSessionId();
            mp.pause();
        }
    }
    public void continuar2(View view){
        if(mp!=null&& mp.isLooping()==false){
            mp.seekTo(posicion);
            mp.start();
        }
    }
    public void detener2(View view){
        if (mp!=null){
            mp.stop();
            posicion=0;
        }
    }
}