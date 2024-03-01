package com.example.besinciders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton kartalButonDegiskeni;
    TextView textDegiskeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kartalButonDegiskeni=(ImageButton) findViewById(R.id.kartalresmi);
        textDegiskeni=(TextView) findViewById(R.id.kartalyazisi);
        kartalButonDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(MainActivity.this,"Kartala tıklandı",Toast.LENGTH_SHORT).show();
                textDegiskeni.setText("Kartala tıklandı");*/

                textDegiskeni.setText("Kartala tıklandı");

            }
        });
    }
}