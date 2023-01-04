package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Ayarlar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        navBar();

    }

    public void navBar(){
        LinearLayout lytVakitler = (LinearLayout)findViewById(R.id.lytVakitler);
        LinearLayout lytAyet = (LinearLayout) findViewById(R.id.lytAyet);
        LinearLayout ltyDua = (LinearLayout) findViewById(R.id.lytDua);
        LinearLayout lytHadis = (LinearLayout)findViewById(R.id.lytHadis);
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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
    }
}