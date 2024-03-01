package com.example.sekizinciders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button gecis;
    Bundle yardimci;
    WebView webViewDegiskeni;



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webViewDegiskeni=(WebView) findViewById(R.id.webview);
        webViewDegiskeni.getSettings().setJavaScriptEnabled(true);
        webViewDegiskeni.loadUrl("https://www.google.com");


        yardimci=new Bundle();
        yardimci.putString("mesaj","merhaba dünya");
        yardimci.putInt("sayisalDeger",100);

        gecis=(Button)findViewById(R.id.gecis);
        gecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hizmet=new Intent(MainActivity.this, ikincisayfa.class);

                hizmet.putExtras(yardimci);
                startActivity(hizmet);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuNesnesi=getMenuInflater();
        menuNesnesi.inflate(R.menu.optionmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i;
        if(item.getItemId()==R.id.sayfa1){
            i=new Intent("android.intent.action.MAIN");
            startActivity(i);
        }
        else if(item.getItemId()==R.id.sayfa2){
            i=new Intent(MainActivity.this, ikincisayfa.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}