package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AllTimes extends AppCompatActivity {

    public static TextView Aimsak, Agunes, Aogle, Aikindi, Aaksam, Ayatsi, Atarih,topluvakitler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplu_vakitler);

        Atarih = (TextView) findViewById(R.id.Ttarih);
        Aimsak = (TextView) findViewById(R.id.Timsak);
        Agunes = (TextView) findViewById(R.id.Tgunes);
        Aogle = (TextView) findViewById(R.id.Togle);
        Aikindi = (TextView) findViewById(R.id.Tikindi);
        Aaksam = (TextView) findViewById(R.id.Taksam);
        Ayatsi = (TextView) findViewById(R.id.Tyatsi);
        topluvakitler = (TextView) findViewById(R.id.topluvakitler);

//        Typeface face = Typeface.createFromAsset(getAssets(), "font/poppins.ttf");
//        topluvakitler.setTypeface(face);

        FetchDataAllTimes process = new FetchDataAllTimes();
        process.execute();

    }
}