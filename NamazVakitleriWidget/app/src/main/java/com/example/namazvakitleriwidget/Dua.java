package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Dua extends AppCompatActivity {

    TextView txtDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        navBar();

        txtDua = (TextView) findViewById(R.id.txtDua);

        String[] arrayDua = getResources().getStringArray(R.array.dualar);
        String randomStrDua = arrayDua[new Random().nextInt(arrayDua.length)];
        txtDua.setText(randomStrDua);

    }

    public void navBar(){
        LinearLayout lytVakitler = (LinearLayout)findViewById(R.id.lytVakitler);
        LinearLayout lytAyet = (LinearLayout) findViewById(R.id.lytAyet);
        LinearLayout lytHadis = (LinearLayout) findViewById(R.id.lytHadis);
        LinearLayout lytAyarlar = (LinearLayout)findViewById(R.id.lytAyarlar);
        lytVakitler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
            }
        });
        lytAyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Ayet.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
            }
        });
        lytHadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Hadis.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
            }
        });
        lytAyarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Ayarlar.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
    }
}