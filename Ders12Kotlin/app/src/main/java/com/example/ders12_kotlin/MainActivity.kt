package com.example.ders12_kotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var secim:Button
    lateinit var radioGroup:RadioGroup
    lateinit var linearLayout: LinearLayout
    lateinit var sariRadio:RadioButton
    lateinit var kirmiziRadio:RadioButton
    lateinit var yesilRadio:RadioButton
    lateinit var cyanRadio:RadioButton
    lateinit var listem:ListView
    lateinit var ratingDegiskeni:RatingBar
    lateinit var ratingSonuc:RatingBar

    val yemekler= listOf("Kuru Fasülye","Lahmacun","Pilav","Kebap","Patates Kızartması","İmam Bayıldı")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        secim=findViewById(R.id.secim)
        radioGroup=findViewById(R.id.renkler)
        linearLayout=findViewById(R.id.main)
        sariRadio=findViewById(R.id.sari)
        kirmiziRadio=findViewById(R.id.kirmizi)
        yesilRadio=findViewById(R.id.yesil)
        cyanRadio=findViewById(R.id.cyan)
        listem=findViewById(R.id.listem)

        ratingDegiskeni=findViewById(R.id.ratingBar)
        ratingSonuc=findViewById(R.id.ratingSonuc)
        ratingDegiskeni.setOnRatingBarChangeListener(object :RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                ratingSonuc.rating=rating
            }
        })


        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,yemekler)
        listem.adapter=adapter
        listem.onItemClickListener=AdapterView.OnItemClickListener{parent,view,position,id->
            val secilenYemek=parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Seçilen yemek= $secilenYemek",Toast.LENGTH_LONG).show()
        }




        kirmiziRadio.setOnClickListener{
           linearLayout.setBackgroundColor(Color.RED)
        }



        sariRadio.setOnClickListener{
            linearLayout.setBackgroundColor(Color.YELLOW)
        }



        yesilRadio.setOnClickListener{
            linearLayout.setBackgroundColor(Color.GREEN)
        }



        cyanRadio.setOnClickListener{
            linearLayout.setBackgroundColor(Color.CYAN)
        }



        /*secim.setOnClickListener{
           var secilenRadioButton=radioGroup.checkedRadioButtonId
            when(secilenRadioButton){
                R.id.kirmizi-> linearLayout.setBackgroundColor(Color.RED)
                R.id.sari-> linearLayout.setBackgroundColor(Color.YELLOW)
                R.id.yesil-> linearLayout.setBackgroundColor(Color.GREEN)
                R.id.ciyan-> linearLayout.setBackgroundColor(Color.CYAN)
            }
        }*/

        secim.setOnClickListener{
            var secilenRadioButton=radioGroup.checkedRadioButtonId
            val rnd = Random.Default
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            linearLayout.setBackgroundColor(color)

        }
    }




}
