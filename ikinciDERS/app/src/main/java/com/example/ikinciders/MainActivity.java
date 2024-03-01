package com.example.ikinciders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   TextView mesajDegiskeni;
   Button  kaydetDegiskeni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesajDegiskeni=(TextView) findViewById(R.id.mesaj);
        kaydetDegiskeni=(Button) findViewById(R.id.kaydet);

        mesajDegiskeni.setText("Merhaba Sınıf!");





    }
}