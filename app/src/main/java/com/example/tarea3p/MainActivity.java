package com.example.tarea3p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText telefono;
    private EditText email;
    private Button btnSalvar;
    private  Button btnRecup;
    private  Button btnPref;
    private static final String FILE_NAME="texto2.txt";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.editTextTextPersonName7);
        telefono=findViewById(R.id.editTextTextPersonName8);
        email=findViewById(R.id.editTextTextPersonName9);
        btnSalvar=findViewById(R.id.button3);
        btnRecup=findViewById(R.id.button);
        btnPref=findViewById(R.id.button2);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savefile();
            }
        });
        btnRecup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readfile();
            }
        });
        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
    private void savefile(){
        String nom=nombre.getText().toString()+"\n";
        String tel=telefono.getText().toString()+"\n";
        String em=email.getText().toString()+"\n";
        FileOutputStream fs=null;
        try{
            fs=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fs.write(nom.getBytes());
            fs.write(tel.getBytes());
            fs.write(em.getBytes());
            Log.d("tag1","fichero salvado en:"+getFilesDir()+"/"+FILE_NAME);
            nombre.getText().clear();;
            telefono.getText().clear();;
            email.getText().clear();
        }
        catch(Exception e){e.printStackTrace();}finally{
            if(fs!=null){
                try{fs.close();}
                catch(Exception e){e.printStackTrace();}
            }
        }

    }
    private void readfile(){
        FileInputStream fi= null;
        try{
            fi= openFileInput(FILE_NAME);
            InputStreamReader isr=new InputStreamReader(fi);
            BufferedReader br=new BufferedReader(isr);
           String ltexto1=br.readLine();
            String ltexto2=br.readLine();
           String ltexto3=br.readLine();

            if(ltexto1!=null)
            {nombre.setText(ltexto1);
                telefono.setText(ltexto2);
                email.setText(ltexto3);}



        }catch(Exception e){e.printStackTrace();
        }finally{
            if(fi!=null){
                try{fi.close();}
                catch(Exception e){e.printStackTrace();}
            }
        }}
}