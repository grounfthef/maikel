package com.wposs.androidya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Button button2 = ((Button) findViewById(R.id.button2));
//        button2.setOnClickListener((evt) -> irAPagina(1));

//        findViewById(R.id.button2).setOnClickListener((evt) -> irAPagina(2));


    }

//    public void irAPagina(int pagina) {
//        switch (pagina) {
//            case 1: lanzarActivity(capturadeunboton.class); break;
//            case 2: lanzarActivity(RadioGroupRadioButton.class); break;
//        }
//    }
//
//    public void lanzarActivity(Class activity) {
//        Intent i = new Intent(this, activity);
//        startActivity(i);
//    }
    public void primero(View view) {
        Intent i = new Intent(this, capturadeunboton.class);
        startActivity(i);
    }

    public void segundo(View view) {
        Intent i = new Intent(this, RadioGroupRadioButton.class);
        startActivity(i);
    }

    public void tercero(View view) {
        Intent i = new Intent(this, ControlCheckBox.class);
        startActivity(i);
    }

    public void cuarto(View view) {
        Intent i = new Intent(this, ControlSpinner.class);
        startActivity(i);
    }

    public void quinto(View view) {
        Intent i = new Intent(this, ControlListView.class);
        startActivity(i);
    }

    public void sexto(View view) {
        Intent i = new Intent(this, ControlImageButton.class);
        startActivity(i);
    }

    public void sextimo(View view) {
        Intent i = new Intent(this, NotificacionesencillasmedianteclaseToast.class);
        startActivity(i);
    }

    public void octavo(View view) {
        Intent i = new Intent(this, ControlEditText.class);
        startActivity(i);
    }

    public void novena(View view) {
        Intent i = new Intent(this, LanzarsegundoActivity.class);
        startActivity(i);
    }

    public void decimo(View view) {
        Intent i = new Intent(this, Almacenamientodedatos.class);
        startActivity(i);
    }

    public void once(View view) {
        Intent i = new Intent(this, memoriainterna.class);
        startActivity(i);
    }

    public void doce(View view) {
        Intent i = new Intent(this, tarjetaSD.class);
        startActivity(i);
    }
    public void trece(View view){
        Intent i = new Intent(this,AlmacenamientoenSQLite.class);
        startActivity(i);
    }
    public void catorce(View view){
        Intent i =new Intent(this, LayoutTableLayout.class);
        startActivity(i);
    }
    public void quince(View view){
        Intent i = new Intent(this,Reproducciondeaudio.class);
        startActivity(i);
    }
}