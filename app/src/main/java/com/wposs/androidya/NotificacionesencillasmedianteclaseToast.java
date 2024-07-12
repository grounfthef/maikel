package com.wposs.androidya;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotificacionesencillasmedianteclaseToast extends AppCompatActivity {
private EditText te3;
private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notificacionesencillasmedianteclase_toast);
        te3= findViewById(R.id.te3);
        num = (int)(Math.random()*100001);
        String cadena= String.valueOf(num);
        Toast notificacion= Toast.makeText(this, cadena, Toast.LENGTH_SHORT);
        notificacion.show();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void controlar(View view){
        String valorIntegresado= te3.getText().toString();
        int valor = Integer.parseInt(valorIntegresado);
        if(valor==num){
            Toast notificacion = Toast.makeText(this, "muy bien recodastes el numero mostrado", Toast.LENGTH_SHORT);
            notificacion.show();
        }else{
            Toast notificacion=Toast.makeText(this,"lo siento no es el numero mostrado.",Toast.LENGTH_LONG);
            notificacion.show();
        }
    }
}