package com.example.ders3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UcuncuSayfa extends AppCompatActivity {
    Button geriDegiskeni;
    TextView ikinciSayfaTextViewDegiskeni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ucuncusayfa);


    }
}
