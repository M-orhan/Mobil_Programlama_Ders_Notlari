package com.example.dorduncuders;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    MediaPlayer sesDosyasi;
    Button startDegiskeni, stopDegiskeni;

    Float deger1,deger2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,"on Create'e girdi",Toast.LENGTH_SHORT).show();

        sesDosyasi=MediaPlayer.create(MainActivity.this,R.raw.tom2);
        stopDegiskeni=(Button) findViewById(R.id.durdurbutonu);
        startDegiskeni=(Button) findViewById(R.id.baslatbuton);

        //sesDosyasi.start();



        startDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"jhgf",Toast.LENGTH_SHORT).show();
                if(sesDosyasi.isPlaying())
                    sesDosyasi.start();
                startDegiskeni.setVisibility(View.INVISIBLE);
                stopDegiskeni.setVisibility(View.VISIBLE);
            }
        });

        stopDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sesDosyasi.isPlaying())
                    sesDosyasi.stop();
                stopDegiskeni.setVisibility(View.INVISIBLE);
                startDegiskeni.setVisibility(View.VISIBLE);
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Stop'a girdi",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Stop'a girdi",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Destroy'a girdi",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Pause'a girdi",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Resume'a girdi",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"on Restart'a girdi",Toast.LENGTH_SHORT).show();
    }

}