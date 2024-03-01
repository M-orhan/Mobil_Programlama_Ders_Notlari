package com.example.ders3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   Button gecisDegiskeni;
   EditText kullanicidanVeriAlanDegiskeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gecisDegiskeni=findViewById(R.id.gecisbutonu);
        kullanicidanVeriAlanDegiskeni=(EditText)
                findViewById(R.id.kullanicidanVeriAlan);


        gecisDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent hizmet=new Intent("android.intent.action.IKINCI");
               // startActivity(hizmet);

                Intent hizmet2=new Intent();
                hizmet2.setClass(MainActivity.this,ikinciSayfa.class);
                startActivity(hizmet2);

                hizmet2.putExtra("gidenVeri", kullanicidanVeriAlanDegiskeni.getText().toString());
                startActivity(hizmet2);

                hizmet2.putExtra("sayi",100);
                startActivity(hizmet2);
            }
        });


        kullanicidanVeriAlanDegiskeni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
               
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }
}