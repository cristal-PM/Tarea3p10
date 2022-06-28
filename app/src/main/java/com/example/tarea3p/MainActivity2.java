package com.example.tarea3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText colorL;
    private EditText colorF;
    private Button cargar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        colorL=findViewById(R.id.edit2);
        colorF=findViewById(R.id.edit1);
        cargar=findViewById(R.id.button3);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gpref();
            }
        });
        cargarpref();
    }

    private void cargarpref() {
        SharedPreferences p=getSharedPreferences("datos1", Context.MODE_PRIVATE);
        String cl=p.getString("colorL","no existe la informacion");
        String cf=p.getString("colorF","no existe la informacion");
        //if(cf!=null) {cargar.setBackgroundColor(Color.parseColor(cf));}
        colorL.setText(cl);
        colorF.setText(cf);

    }

    private  void gpref(){
        SharedPreferences p=getSharedPreferences("datos1", Context.MODE_PRIVATE);
        String cl=colorL.getText().toString();
        String cf=colorF.getText().toString();
        SharedPreferences.Editor editor=p.edit();
        editor.putString("colorL",cl);
        editor.putString("colorF",cf);
        colorL.setText(cl);
        colorF.setText(cf);
        editor.commit();
    }
}