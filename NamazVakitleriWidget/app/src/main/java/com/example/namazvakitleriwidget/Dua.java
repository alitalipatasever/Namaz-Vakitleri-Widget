package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Dua extends AppCompatActivity {

    TextView txtDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        txtDua = (TextView) findViewById(R.id.txtDua);

        String[] arrayDua = getResources().getStringArray(R.array.dualar);
        String randomStrDua = arrayDua[new Random().nextInt(arrayDua.length)];
        txtDua.setText(randomStrDua);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
    }
}