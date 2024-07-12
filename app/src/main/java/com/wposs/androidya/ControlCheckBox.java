package com.wposs.androidya;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ControlCheckBox extends AppCompatActivity {
private EditText tex1,tex2;
private TextView tV1;
private CheckBox cB1,cB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_control_check_box);

        tex1=findViewById(R.id.tex1);
        tex2=findViewById(R.id.tex2);
        tV1=findViewById(R.id.tV1);
        cB1=findViewById(R.id.cB1);
        cB2=findViewById(R.id.cB2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void operar (View view){
        String valor1= tex1.getText().toString();
        String valor2= tex2.getText().toString();
        int nmr1=Integer.parseInt(valor1);
        int nmr2=Integer.parseInt(valor2);
        String resu="";
        if(cB1.isChecked()==true){
            int suma=nmr1+nmr2;
            resu="la suma es: "+ suma;
        }
        if(cB2.isChecked()==true){
            int resta=nmr1-nmr2;
            resu=resu + "la resta es: "+resta;
        }
        tV1.setText(resu);
    }
}