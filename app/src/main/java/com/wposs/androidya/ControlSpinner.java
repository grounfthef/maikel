package com.wposs.androidya;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ControlSpinner extends AppCompatActivity {
private Spinner spinner;
private EditText teo1,teo2;
private TextView TV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_control_spinner);
        teo1= findViewById(R.id.teo1);
        teo2= findViewById(R.id.teo2);
        TV2= findViewById(R.id.TV2);
        spinner=findViewById(R.id.spinner);
        String []opciones ={"sumar","resta","multiplicar","dividir"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        spinner.setAdapter(adapter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void operar(View view){
        String valor1 = teo1.getText().toString();
        String valor2 = teo2.getText().toString();
        int nmr1=Integer.parseInt(valor1);
        int nmr2=Integer.parseInt(valor2);
        String selec= spinner.getSelectedItem().toString();
        if(selec.equals("sumar")){
            int suma= nmr1+nmr2;
            String resu=String.valueOf(suma);
            TV2.setText(resu);
        }
        else if (selec.equals("resta")){
            int resta= nmr1-nmr2;
            String resu=String.valueOf(resta);
            TV2.setText(resu);
        }
        else if (selec.equals("multiplicar")) {
            int multi=nmr1*nmr2;
            String resu=String.valueOf(multi);
            TV2.setText(resu);
        }
        else if (selec.equals("dividir")) {
            int divi= nmr1/nmr2;
            String resu=String.valueOf(divi);
            TV2.setText(resu);
        }
    }
}