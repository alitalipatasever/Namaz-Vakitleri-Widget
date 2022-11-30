package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Ayet extends AppCompatActivity {

    TextView txtAyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayet);

        navBar();

        txtAyet =(TextView) findViewById(R.id.txtAyet);

        String[] arrayAyet = getResources().getStringArray(R.array.ayetler);
        String randomStrAyet = arrayAyet[new Random().nextInt(arrayAyet.length)];
        txtAyet.setText(randomStrAyet);
    }

    public void navBar(){
        LinearLayout lytVakitler = (LinearLayout)findViewById(R.id.lytVakitler);
        LinearLayout ltyHadis = (LinearLayout) findViewById(R.id.lytHadis);
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
        ltyHadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Hadis.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
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