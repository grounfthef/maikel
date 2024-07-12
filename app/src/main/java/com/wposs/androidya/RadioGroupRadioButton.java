package com.wposs.androidya;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioGroupRadioButton extends AppCompatActivity {
private EditText tx1,tx2;
private TextView TV1;
private RadioButton r1,r2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_group_radio_button);
        tx1=findViewById(R.id.tx1);
        tx2=findViewById(R.id.tx2);
        TV1=findViewById(R.id.TV1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void operar(View view){
        String valor1= tx1.getText().toString();
        String valor2= tx2.getText().toString();
        int nmr1= Integer.parseInt(valor1);
        int nmr2= Integer.parseInt(valor2);
        if (r1.isChecked()==true){
            int suma=nmr1+nmr2;
            String resu= String.valueOf(suma);
            TV1.setText(resu);
        }else
        if (r2.isChecked()==true){
            int resta= nmr1-nmr2;
            String resu=String.valueOf(resta);
            TV1.setText(resu);
        }
    }
}