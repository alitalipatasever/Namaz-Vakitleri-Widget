package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;

import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;


public class MainActivity extends AppCompatActivity {

    public static TextView imsak, gunes, ogle, ikindi, aksam, yatsi, tarih, dua, hadis, ayet;
    Button guncelle, topluvakitler;
    public static String fetchTarih, fetchImsak, fetchGunes, fetchOgle, fetchIkindi, fetchAksam, fetchYatsi, fetchAyinSekliURL;
    ImageView DimgMoon;
    LinearLayout ltyAyet;

    Timer timer;
    TextView txttimer;
    public static String[] dizi;
    GifImageView imgMoon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        imsak = (TextView) findViewById(R.id.txtimsak);
        gunes = (TextView) findViewById(R.id.txtgunes);
        ogle = (TextView) findViewById(R.id.txtogle);
        ikindi = (TextView) findViewById(R.id.txtikindi);
        aksam = (TextView) findViewById(R.id.txtaksam);
        yatsi = (TextView) findViewById(R.id.txtyatsi);
        guncelle = (Button) findViewById(R.id.guncelle);
        topluvakitler = (Button) findViewById(R.id.topluvakitler);
        tarih = (TextView) findViewById(R.id.txttarih);
        txttimer = (TextView)findViewById(R.id.txttimer);
        ltyAyet = (LinearLayout)findViewById(R.id.lytAyet);

        ltyAyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Ayet.class);
                startActivity(intent);
            }
        });

//        String[] arrayDua = getResources().getStringArray(R.array.dualar);
//        String randomStrDua = arrayDua[new Random().nextInt(arrayDua.length)];
//        dua.setText(randomStrDua);
//
//        String[] arrayHadis = getResources().getStringArray(R.array.hadisler);
//        String randomStrHadis = arrayHadis[new Random().nextInt(arrayHadis.length)];
//        hadis.setText(randomStrHadis);
//
//        String[] arrayAyet = getResources().getStringArray(R.array.ayetler);
//        String randomStrAyet = arrayAyet[new Random().nextInt(arrayAyet.length)];
//        ayet.setText(randomStrAyet);

        FetchData process = new FetchData();
        process.execute();
        String urlMoon =fetchAyinSekliURL;

        //Uri uri = Uri.parse(urlMoon);

        //Picasso.get().load("http://namazvakti.diyanet.gov.tr/images/sd6.gif").into(imgMoon);
        //Picasso.get().load("https://tenor.com/bcvNG.gif").into(imgMoon);
        /*Glide.with(MainActivity.this) // replace with 'this' if it's in activity
             .load("https://media.giphy.com/media/6KWP7iszpQvFJNA1dc/giphy.gif")
             .error(R.drawable.dolunay) // show error drawable if the image is not a gif
             .into(imgMoon);*/

//        imgMoon.setImageBitmap(getBitmap("http://namazvakti.diyanet.gov.tr/images/sd6.gif"));


        new CountDownTimer(6000000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                txttimer.setText(f.format(hour) + ":" + f.format(min)+ ":" + f.format(sec)); // + ":" + f.format(sec)
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                txttimer.setText("00:00:00");
            }
        }.start();

//        timer = new Timer(500000,1000);
//        timer.start();

//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("dd");
//        String strDate = dateFormat.format(date);
//        //String strDate = "20.12.2021";
//        int daynum = Integer.parseInt(strDate);
//
//
//        //dizideneme.setText(dizi[daynum]);

    }

    /*public void onViewCreated(View view, Bundle savedInstanceState)
    {
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here

        }
    }*/

    public Bitmap getBitmap(String url)
    {
        Bitmap bmp = null;
        try
        {
            HttpClient client = new DefaultHttpClient();
            URI imageUri = new URI(url);
            HttpGet req = new HttpGet();
            req.setURI(imageUri);
            HttpResponse resp = client.execute(req);
            bmp = BitmapFactory.decodeStream(resp.getEntity().getContent());
        }
        catch(URISyntaxException ex)
        {
            Log.e("ERROR", ex.getMessage());
        }
        catch(ClientProtocolException ex)
        {
            Log.e("ERROR", ex.getMessage());
        }
        catch(IllegalStateException ex)
        {
            Log.e("ERROR", ex.getMessage());
        }
        catch(IOException ex)
        {
            Log.e("ERROR", ex.getMessage());
        }

        return bmp;
    }

    public void onClick(View view) {
        if (view == guncelle) {
            Toast.makeText(getApplicationContext(), "Namaz Vakitleri Güncelleniyor...", Toast.LENGTH_SHORT).show();
            FetchData process = new FetchData();
            process.execute();

//            Intent intent = new Intent(this,NewAppWidget.class);
//            NewAppWidget.newdata = strImsak;
//            //NewAppWidget.updateWidgets(getApplicationContext());
//            intent.putExtra("Imsak",strImsak);
//            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            startActivity(intent);

        }else if(view == topluvakitler){
            Intent intent = new Intent(this, AllTimes.class);
            startActivity(intent);
        }
    }



}
