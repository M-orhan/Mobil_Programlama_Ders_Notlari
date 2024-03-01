package com.example.dokuzuncuders;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mesaj;
    EditText telefonNumarasi;
    Button smsGonder,aramaYap;
    SeekBar mesajSayisi;
    String numara,mesajicerik;
    Intent aramaIntent;
    int sayac=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aramaIntent=new Intent(Intent.ACTION_CALL);


        mesajSayisi=(SeekBar)findViewById(R.id.mesajsayisi);
        mesaj=(EditText) findViewById(R.id.mesaj);
        telefonNumarasi=(EditText) findViewById(R.id.telefonnumarasi);

        smsGonder=(Button) findViewById(R.id.sms);
        aramaYap=(Button) findViewById(R.id.call);

        mesajSayisi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sayac=progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        smsGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numara=telefonNumarasi.getText().toString().trim();
                mesajicerik=mesaj.getText().toString().trim();
                if(numara.length()==0 || mesajicerik.length()==0 ){
                    Toast.makeText(MainActivity.this,"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();

                }
                else if(numara.length()!=11){
                    Toast.makeText(MainActivity.this,"Lütfen Telefon Numarasını Doğru Girin",Toast.LENGTH_SHORT).show();
                }
                else{
                    //mesaj atma
                    Intent hizmet=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,hizmet, PendingIntent.FLAG_MUTABLE);


                    SmsManager smsManager=SmsManager.getDefault();
                    for(int i=0;i<sayac;i++){
                    smsManager.sendTextMessage(numara,null,mesajicerik,pi,null);
                    }

                    mesaj.setText("");
                    telefonNumarasi.setText("");
                }

            }
        });

        aramaYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   numara=telefonNumarasi.getText().toString().trim();
                   if(numara.length()==0){
                       Toast.makeText(MainActivity.this,"Lütfen Telefon Numarası girin",Toast.LENGTH_SHORT).show();
                   }
                   else if(numara.length()!=11){
                       Toast.makeText(MainActivity.this, "Lütfen Telefon Numarasını doğru girin", Toast.LENGTH_SHORT).show();
                   }
                   else {
                       //arama yap
                       aramaIntent.setData(Uri.parse("tel:"+numara));
                       startActivity(aramaIntent);
                   }
            }
        });


    }



}