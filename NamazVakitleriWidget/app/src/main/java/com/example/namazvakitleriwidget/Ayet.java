package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Ayet extends AppCompatActivity {

    TextView txtAyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayet);

        txtAyet =(TextView) findViewById(R.id.txtAyet);

        String[] arrayAyet = getResources().getStringArray(R.array.ayetler);
        String randomStrAyet = arrayAyet[new Random().nextInt(arrayAyet.length)];
        txtAyet.setText(randomStrAyet);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_left_out_reverse, R.anim.anim_right_in_reverse);
    }
}