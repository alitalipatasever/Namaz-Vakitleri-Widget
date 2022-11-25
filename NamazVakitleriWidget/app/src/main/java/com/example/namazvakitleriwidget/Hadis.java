package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Hadis extends AppCompatActivity {

    TextView txtHadis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadis);

        txtHadis = (TextView) findViewById(R.id.txtHadis);

        String[] arrayHadis = getResources().getStringArray(R.array.hadisler);
        String randomStrHadis = arrayHadis[new Random().nextInt(arrayHadis.length)];
        txtHadis.setText(randomStrHadis);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
    }
}