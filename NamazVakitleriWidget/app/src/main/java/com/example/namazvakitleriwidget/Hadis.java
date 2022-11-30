package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Hadis extends AppCompatActivity {

    TextView txtHadis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadis);

        navBar();

        txtHadis = (TextView) findViewById(R.id.txtHadis);

        String[] arrayHadis = getResources().getStringArray(R.array.hadisler);
        String randomStrHadis = arrayHadis[new Random().nextInt(arrayHadis.length)];
        txtHadis.setText(randomStrHadis);

    }

    public void navBar(){
        LinearLayout lytVakitler = (LinearLayout)findViewById(R.id.lytVakitler);
        LinearLayout lytAyet = (LinearLayout) findViewById(R.id.lytAyet);
        LinearLayout ltyDua = (LinearLayout) findViewById(R.id.lytDua);
        LinearLayout ltyAyarlar = (LinearLayout)findViewById(R.id.lytAyarlar);
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
        ltyDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Dua.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
            }
        });
        ltyAyarlar.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }


}