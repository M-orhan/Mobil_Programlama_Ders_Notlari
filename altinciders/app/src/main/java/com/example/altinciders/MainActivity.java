package com.example.altinciders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox makarnaDegiskeni,kebapDegiskeni,iskenderDegiskeni,pilavDegiskeni,tazefasulyeDegiskeni;
    Button yemeklerbutonuDegiskeni;
    TextView yemeksonucuDegiskeni;
    String yemekler;
    Button gecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makarnaDegiskeni=(CheckBox) findViewById(R.id.makarna);
        kebapDegiskeni=(CheckBox) findViewById(R.id.kebap);
        iskenderDegiskeni=(CheckBox)findViewById(R.id.iskender);
        pilavDegiskeni=(CheckBox)findViewById(R.id.pilav);
        tazefasulyeDegiskeni=(CheckBox)findViewById(R.id.tazefasulye);

        yemeklerbutonuDegiskeni=(Button) findViewById(R.id.yemeklerbutonu);

        yemeksonucuDegiskeni=(TextView) findViewById(R.id.yemeksonucu);
        gecis=(Button)findViewById(R.id.gecis);
        gecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ikincisayfa.class);
                startActivity(i);
            }
        });



        makarnaDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(makarnaDegiskeni.isChecked())
                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        Button show = (Button) findViewById(R.id.yemeklerbutonu);
           yemeklerbutonuDegiskeni.setEnabled(false);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     yemekler="";
                if(makarnaDegiskeni.isChecked())
                    yemekler+="Makarna ";

                if(kebapDegiskeni.isChecked())
                    yemekler+="Kebap ";

                if(iskenderDegiskeni.isChecked())
                    yemekler+="İskender ";

                if(pilavDegiskeni.isChecked())
                    yemekler+="Pilav ";

                if(tazefasulyeDegiskeni.isChecked())
                    yemekler+="Taze Fasulye ";
                ;;



                yemeksonucuDegiskeni.setText(yemekler + "seviyorsunuz");
            }
        });

        iskenderDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(iskenderDegiskeni.isChecked()) {
                    yemeklerbutonuDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "İskender seçildi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "İskender seçili değil", Toast.LENGTH_SHORT).show();
                    yemeklerbutonuDegiskeni.setEnabled(false);
                }
            }
        });


    }
}