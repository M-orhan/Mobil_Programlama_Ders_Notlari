package com.example.ders3;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ikinciSayfa extends AppCompatActivity
{
    Button ileriDegiskeni;
    TextView ikinciSayfaTextViewDegiskeni;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);
        ileriDegiskeni=findViewById(R.id.ilerisayfabutonu);
        ikinciSayfaTextViewDegiskeni=findViewById(R.id.ikinciSayfaTextView);

        Intent hizmet2=getIntent();
        String gelenVeri=hizmet2.getStringExtra("gidenVeri");
        int sayiDegiskeni=hizmet2.getIntExtra("sayi",0);

        ikinciSayfaTextViewDegiskeni.setText(gelenVeri +" "+ sayiDegiskeni);

        ileriDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent hizmet=new Intent("android.intent.action.IKINCI");
                // startActivity(hizmet);

                Intent gerihizmet=new Intent();
                gerihizmet.setClass(ikinciSayfa.this,UcuncuSayfa.class);
                startActivity(gerihizmet);
            }
        });


    }
}

