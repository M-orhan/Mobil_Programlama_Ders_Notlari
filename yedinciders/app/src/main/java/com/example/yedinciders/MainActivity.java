package com.example.yedinciders;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer player;
    Button playButonu,pauseButonu,stopButonu;
     ListView listeDegisken;
     TextView calanDegisken;
     SeekBar volumeDegisken;
     String sarkilar[]={"İmparator","Doğuştan Beri Haklıyım","Basit Numaralar","Gülü Sevdim Dikeni Battı","Bertaraf"};

     int sira;
  View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calanDegisken=(TextView) findViewById(R.id.sonuc);
        volumeDegisken=(SeekBar) findViewById(R.id.deger);
        listeDegisken=(ListView) findViewById(R.id.liste);
        playButonu=(Button) findViewById(R.id.play);
        pauseButonu=(Button) findViewById(R.id.pause);
        stopButonu=(Button) findViewById(R.id.bstop);

        AudioManager sesKontrol=(AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume=sesKontrol.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeDegisken.setMax(maxVolume);
        int ses=sesKontrol.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeDegisken.setProgress(ses);

        volumeDegisken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sesKontrol.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        listeDegisken.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,sarkilar));
        listeDegisken.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calanDegisken.setText(listeDegisken.getItemAtPosition(position)+"");
                sira=(int)listeDegisken.getItemIdAtPosition(position);
                stopPlaying();
            }
        });

        playButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sira==0) {
                    player = MediaPlayer.create(MainActivity.this, R.raw.imparator);
                    player.start();
                }
                else if (sira==1) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.dogustan);
                    player.start();
                }
                else if (sira==2) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.basitnumaralar);
                    player.start();
                }
                else if (sira==3) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.gulusevdim);
                    player.start();
                }
                else if (sira==4) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.bertaraf);
                    player.start();
                }
            }
        });
        pauseButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying())
                    player.pause();
            }
        });
        stopButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying())
                    player.stop();
            }
        });
    }
    public void stopPlaying(){
        if (player!=null) {
            player.stop();
            player.release();
            player=null;
        }
    }
}















