package com.wposs.androidya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Almacenamientodedatos extends AppCompatActivity {
    private EditText et18;
    private TextView tv2;
    private TextView tv3;
    private int num;
    private int num1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_almacenamientodedatos);
        et18 = findViewById(R.id.et18);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        num = getNumAleatorio();
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        tv2.setText(prefe.getString("mail",""));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private static int getNumAleatorio() {
        return 1 + (int) (Math.random() * 50);
    }

    public void verificar(View view) {

        String valoringresado = et18.getText().toString();
        int valor = Integer.parseInt(valoringresado);
        if (valor == num) {
            Toast notificacion = Toast.makeText(this, "el numero es el correcto", Toast.LENGTH_LONG);
            notificacion.show();
            num1 = num1 + 1;
            tv2.setText(String.valueOf(num1));
            num = getNumAleatorio();
        } else if (valor > num) {
            Toast notificacion = Toast.makeText(this, "el numero es menor", Toast.LENGTH_LONG);
            notificacion.show();
        } else if (valor < num) {
            Toast notificacion = Toast.makeText(this, "el numero es mayor", Toast.LENGTH_LONG);
            notificacion.show();
        }
        SharedPreferences preferences=getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("mail",tv2.getText().toString());
        editor.commit();
    }
}