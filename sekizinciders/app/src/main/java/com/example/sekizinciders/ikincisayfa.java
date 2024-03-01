package com.example.sekizinciders;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class ikincisayfa extends AppCompatActivity{

    TextView gosterTexti;

    ImageView imageViewNesnesi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);

        imageViewNesnesi=(ImageView)findViewById(R.id.imageView);
        imageViewNesnesi.setImageResource(R.drawable.cicek);

        String path= Environment.getExternalStorageDirectory()+ "/Images/Pictures/IMG_20240220_132520.JPG";

        File dosya=new File(path);
        if(dosya.exists()){
            Bitmap bitmapFormati= BitmapFactory.decodeFile(dosya.getAbsolutePath());
            imageViewNesnesi.setImageBitmap(bitmapFormati);
        }

        gosterTexti=(TextView)findViewById(R.id.goster);
        gosterTexti.setText(path);

        /*try {
            Bundle karsila = getIntent().getExtras();
            String gelenmesaj = karsila.getString("mesaj");
            int gelenSayisalDeger = karsila.getInt("sayisalDeger");

            gosterTexti.setText(gelenmesaj + " " + gelenSayisalDeger);
        }
        catch (Exception e){}*/





    }
}



