package com.wposs.androidya;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class memoriainterna extends AppCompatActivity {
private EditText eTM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_memoriainterna);
        eTM= findViewById(R.id.eTM);
        String[] archivos =fileList();

        if(existe(archivos,"notas.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while(linea !=null){
                    todo = todo + linea + "\n";
                    linea= br.readLine();
                }
                br.close();
                archivo.close();
                eTM.setText(todo);
            } catch (IOException e) {
            }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean existe(String[] archivos, String archibusca) {
        for (int f=0;f<archivos.length;f++)
            if (archibusca.equals(archivos[f]))
                return true;
        return false;
    }
    public void grabar(View view){
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(" notas.txt", Activity.MODE_PRIVATE));
        } catch (FileNotFoundException e) {
        }
        Toast t = Toast.makeText(this, "los datos furon grabados", Toast.LENGTH_SHORT);
        t.show();
        finish();
    }
}