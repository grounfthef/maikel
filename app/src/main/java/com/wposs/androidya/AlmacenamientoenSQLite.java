package com.wposs.androidya;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlmacenamientoenSQLite extends AppCompatActivity {
public EditText eT,eTT,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_almacenamientoen_sqlite);
        eT=findViewById(R.id.eT);
        eTT=findViewById(R.id.eTT);
        et2=findViewById(R.id.et2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void alta(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = eT.getText().toString();
        String descri = eTT.getText().toString();
        String pre = et2.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("descripcion",descri);
        registro.put("precio",pre);
        bd.insert("articulos",null,registro);
        bd.close();
        eT.setText("");
        eTT.setText("");
        et2.setText("");
        Toast.makeText(this,"se cargan los datos del articulo",Toast.LENGTH_SHORT).show();

    }
    public void codigo(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = eT.getText().toString();
        Cursor fila = bd.rawQuery("select decripcion,precio from articulo where codigo="+cod,null);
        if (fila.moveToFirst()){
            eTT.setText(fila.getString(0));
            et2.setText(fila.getString(1));
        }else
            Toast.makeText(this, "no existe un articulo con dicho codigo", Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void descripcion(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String descri = eTT.getText().toString();
        Cursor fila = bd.rawQuery("select decripcion,precio from articulo where codigo= '"+ descri +"'",null);
        if (fila.moveToFirst()){
            eT.setText(fila.getString(0));
            eTT.setText(fila.getString(1));
        }else
            Toast.makeText(this, "no existe un articulo con dicho codigo", Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void bajar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod =eT.getText().toString();
        int cant= bd.delete("articulos","codigo="+cod,null);
        bd.close();
        eT.setText("");
        eTT.setText("");
        et2.setText("");
        if (cant==1)
            Toast.makeText(this,"se borro el articulo con dicho codigo",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "no existe un articulo con dicho codigo", Toast.LENGTH_SHORT).show();
    }
    public void modificacion(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = eT.getText().toString();
        String descri = eTT.getText().toString();
        String pre = et2.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("cogigo",cod);
        registro.put("descripcion",descri);
        registro.put("precio",pre);
        int cant = bd.update("articulo",registro,"codigo=", cod,null);
        if(cant)

    }
}