package com.example.altinciders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ikincisayfa extends AppCompatActivity {
    RadioGroup radyolar;
    RadioButton kralfm,metrofm,bestfm,powerfm;
    TextView secimSonuc;
    String secim;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);

        radyolar=(RadioGroup) findViewById(R.id.radyolar);
        kralfm=(RadioButton) findViewById(R.id.kralfm);
        metrofm=(RadioButton) findViewById(R.id.metrofm);
        bestfm=(RadioButton) findViewById(R.id.bestfm);
        powerfm=(RadioButton) findViewById(R.id.powerfm);

        secimSonuc= (TextView) findViewById(R.id.secim);

        int secilenRadyo=radyolar.getCheckedRadioButtonId();
        if(secilenRadyo==R.id.bestfm)
            secimSonuc.setText("Best Fm dinliyorsunuz");
        else if(secilenRadyo==R.id.kralfm)
            secimSonuc.setText("Kral Fm dinliyorsunuz");
        else if(secilenRadyo==R.id.metrofm)
            secimSonuc.setText("Metro Fm dinliyorsunuz");
        else if(secilenRadyo==R.id.powerfm)
            secimSonuc.setText("Metro Fm dinliyorsunuz");

        Button show = (Button) findViewById(R.id.secimbutonu);
        secimSonuc.setEnabled(false);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secim="";
                if(metrofm.isChecked())
                    secim+="Metro FM  ";

                if(powerfm.isChecked())
                    secim+="Power FM ";

                if(kralfm.isChecked())
                    secim+="Kral FM ";

                if(bestfm.isChecked())
                    secim+="Best FM ";


                ;;



                secimSonuc.setText(secim + "dinliyorsunuz");
            }
        });

        metrofm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(metrofm.isChecked()) {
                    metrofm.setEnabled(true);
                    Toast.makeText(ikincisayfa.this, "İskender seçildi", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ikincisayfa.this, "İskender seçili değil", Toast.LENGTH_SHORT).show();
                    metrofm.setEnabled(false);
                }
            }
        });

    }
}

