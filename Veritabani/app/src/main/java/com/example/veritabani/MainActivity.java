package com.example.veritabani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button sil,duzelt,kaydet;
    EditText not;

    RecyclerView liste;
    ArrayList<Notlar>gelenNotlar=new ArrayList<>();

    String notId=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        not=(EditText) findViewById(R.id.not);
        kaydet=(Button) findViewById(R.id.kaydet);
        duzelt=(Button) findViewById(R.id.duzelt);
        sil=(Button) findViewById(R.id.sil);

        liste=(RecyclerView) findViewById(R.id.liste);
        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        listeyiGetir();

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((not.getText().toString().trim().length() !=0))
                {
                    kaydet();
                    listeyiGetir();
                    Toast.makeText(MainActivity.this,"Not kaydedildi.",Toast.LENGTH_SHORT).show();
                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);

                    notId="1";
                    not.setText("");

                }
                else
                    Toast.makeText(MainActivity.this,"Lütfen boş değer girmeyin",Toast.LENGTH_SHORT).show();
            }
        });

        duzelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((not.getText().toString().trim().length() !=0)){
              duzelt();
              listeyiGetir();
                    Toast.makeText(MainActivity.this,"Not düzeltildi.",Toast.LENGTH_SHORT).show();
                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                    not.setText("");
                }
                else
                    Toast.makeText(MainActivity.this,"Lütfen boş değer girmeyin",Toast.LENGTH_SHORT).show();
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(notId!="") {
                   sil();
                   listeyiGetir();
                   Toast.makeText(MainActivity.this,"Not silindi.",Toast.LENGTH_SHORT).show();
                   notId="";
                   not.setText("");
               }
                else
                   Toast.makeText(MainActivity.this,"Silme işlemi başarısız!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    void kaydet(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notEkle(not.getText().toString());
        db.close();
    }

    void listeyiGetir()
    {
        DatabaseHelper db=
                new DatabaseHelper(getApplicationContext()) ;
        gelenNotlar=db.notlariGetir();
        NotAdaptor notadapetorsinif=
                new NotAdaptor(this,gelenNotlar);
        LinearLayoutManager layoutum=new
                LinearLayoutManager(getApplicationContext());
        liste.setLayoutManager(layoutum);
        liste.setHasFixedSize(true);
        liste.setAdapter(notadapetorsinif);

        notadapetorsinif.setOnItemClickListener(kendimClikcOlusturdum);
        db.close();
    }

    View.OnClickListener kendimClikcOlusturdum
            =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder=
                    (RecyclerView.ViewHolder)v.getTag();
            int i=viewHolder.getAdapterPosition();
            Notlar item=gelenNotlar.get(i);
            not.setText(item.getNotIcerik());
            notId=item.getNotId();
        }
    };

    View.OnClickListener kendimClickOlusturdum=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder=(RecyclerView.ViewHolder)v.getTag();
            int i=viewHolder.getAdapterPosition();
            Notlar item=gelenNotlar.get(i);
            not.setText(item.getNotIcerik());
            notId=item.getNotId();

        }
    };

    void duzelt(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notDuzelt(notId,not.getText().toString());
        db.close();
    }

    void sil(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notSil(notId);
        db.close();
    }
}