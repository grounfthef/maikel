package com.wposs.androidya;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class tarjetaSD extends AppCompatActivity {
    private EditText eTT,eTTM;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tarjeta_sd);
        eTT=findViewById(R.id.et2);
        eTTM= findViewById(R.id.eTTM);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void grabar(View view){
        String normarchivo = eTT.getText().toString();
        String contenido = eTTM.getText().toString();
        try {
            File file = new File(getExternalFilesDir(null),normarchivo);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            Toast.makeText(this,"los datos fueron grabados correctamente",Toast.LENGTH_SHORT).show();
            eTT.setText("");
            eTTM.setText("");
        }catch (IOException ioe){
            Toast.makeText(this, "no se pudo grabar", Toast.LENGTH_SHORT).show();
        }
    }
    public void racuperar(View view){
        File file= new File(getExternalFilesDir(null),eTT.getText().toString());
        try {
            FileInputStream fIn = new FileInputStream(file);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo = "";
            while (linea!=null){
                todo= todo + linea + "";
                linea = br.readLine();
            }
            br.close();
            archivo.close();
            eTTM.setText(todo);
        }catch (IOException e){
            Toast.makeText(this, "no se pudo leer ", Toast.LENGTH_SHORT).show();
        }
    }
}