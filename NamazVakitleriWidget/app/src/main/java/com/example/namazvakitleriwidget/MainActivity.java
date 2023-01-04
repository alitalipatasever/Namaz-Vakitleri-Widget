package com.example.namazvakitleriwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifImageView;


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



        objectDecleration();
        navBar();

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        /*ltyAyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Ayet.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
            }
        });*/

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


        /*
        new CountDownTimer(500000, 1000) {
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
        */

        new CountDownTimer(Long.MAX_VALUE, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                /*NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                txttimer.setText(f.format(hour) + ":" + f.format(min)+ ":" + f.format(sec)); // + ":" + f.format(sec)*/
                if (!aksam.getText().toString().equals("00:00")) {
                    /*Calendar calendar = Calendar.getInstance();
                    int hour24hrs = calendar.get(Calendar.HOUR_OF_DAY);
                    int hour12hrs = calendar.get(Calendar.HOUR);
                    int minutes = calendar.get(Calendar.MINUTE);
                    int seconds = calendar.get(Calendar.SECOND);
                    System.out.println("Current hour 24hrs format:  " + hour24hrs + ":" + minutes + ":" + seconds);
                    System.out.println("Current hour 12hrs format:  " + hour12hrs + ":" + minutes + ":" + seconds);

                    String aksams[] = aksam.getText().toString().split(":");
                    long aksamH = TimeUnit.HOURS.toMillis(Integer.parseInt(aksams[0]));
                    long aksamM = TimeUnit.MINUTES.toMillis(Integer.parseInt(aksams[1]));

                    long aksamHM = aksamH + aksamM;

                    long currentH = TimeUnit.HOURS.toMillis(hour24hrs);
                    long currentM = TimeUnit.MINUTES.toMillis(minutes);

                    long currentHM = currentH + currentM;

                    //double difference = (aksamHM - currentHM) / 1e6;
                    long difference = aksamHM - currentHM;

                    String kalanZaman = String.format(
                            "%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                            TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                    TimeUnit.MILLISECONDS.toHours(difference)));

                    txttimer.setText(kalanZaman);*/



                    Calendar calendar = Calendar.getInstance();
                    int hour24hrs = calendar.get(Calendar.HOUR_OF_DAY);
                    int hour12hrs = calendar.get(Calendar.HOUR);
                    int minutes = calendar.get(Calendar.MINUTE);
                    int seconds = calendar.get(Calendar.SECOND);
                    System.out.println("Current hour 24hrs format:  " + hour24hrs + ":" + minutes + ":" + seconds);
                    System.out.println("Current hour 12hrs format:  " + hour12hrs + ":" + minutes + ":" + seconds);

                    //hour24hrs = 8;
                    //minutes = 3;

                    String imsaks[] = imsak.getText().toString().split(":");
                    long imsakH = TimeUnit.HOURS.toMillis(Integer.parseInt(imsaks[0]));
                    long imsakM = TimeUnit.MINUTES.toMillis(Integer.parseInt(imsaks[1]));

                    String guness[] = gunes.getText().toString().split(":");
                    long gunesH = TimeUnit.HOURS.toMillis(Integer.parseInt(guness[0]));
                    long gunesM = TimeUnit.MINUTES.toMillis(Integer.parseInt(guness[1]));

                    String ogles[] = ogle.getText().toString().split(":");
                    long ogleH = TimeUnit.HOURS.toMillis(Integer.parseInt(ogles[0]));
                    long ogleM = TimeUnit.MINUTES.toMillis(Integer.parseInt(ogles[1]));

                    String ikindis[] = ikindi.getText().toString().split(":");
                    long ikindiH = TimeUnit.HOURS.toMillis(Integer.parseInt(ikindis[0]));
                    long ikindiM = TimeUnit.MINUTES.toMillis(Integer.parseInt(ikindis[1]));

                    String aksams[] = aksam.getText().toString().split(":");
                    long aksamH = TimeUnit.HOURS.toMillis(Integer.parseInt(aksams[0]));
                    long aksamM = TimeUnit.MINUTES.toMillis(Integer.parseInt(aksams[1]));

                    String yatsis[] = yatsi.getText().toString().split(":");
                    long yatsiH = TimeUnit.HOURS.toMillis(Integer.parseInt(yatsis[0]));
                    long yatsiM = TimeUnit.MINUTES.toMillis(Integer.parseInt(yatsis[1]));

                    String yirmi4s[] = "24:00".split(":");
                    long yirmi4sH = TimeUnit.HOURS.toMillis(Integer.parseInt(yirmi4s[0]));
                    long yirmi4sM = TimeUnit.MINUTES.toMillis(Integer.parseInt(yirmi4s[1]));

                    //String altmiss = "60";
                    //long altmisS = TimeUnit.SECONDS.toMillis(Long.parseLong(altmiss));
                    int altmisS = 60;

                    long imsakHM = imsakH + imsakM;
                    long ogleHM = ogleH + ogleM;
                    long ikindiHM = ikindiH + ikindiM;
                    long aksamHM = aksamH + aksamM;
                    long yatsiHM = yatsiH + yatsiM;
                    long gunesHM = gunesH + gunesM;
                    long yirmi4sHM = yirmi4sH + yirmi4sM;

                    long currentH = TimeUnit.HOURS.toMillis(hour24hrs);
                    long currentM = TimeUnit.MINUTES.toMillis(minutes);

                    long currentHM = currentH + currentM;

                    //double difference = (aksamHM - currentHM) / 1e6;

                    int kalanSaniye = altmisS - seconds;

                    if (kalanSaniye == 60) {
                        kalanSaniye = 0;
                    }

                    if (currentHM < imsakHM) {
                        long difference = imsakHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                    else if (currentHM < gunesHM) {
                        long difference = gunesHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                    else if (currentHM < ogleHM) {
                        long difference = ogleHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                    else if (currentHM < ikindiHM) {
                        long difference = ikindiHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                    else if (currentHM < aksamHM) {
                        long difference = aksamHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                    else if (currentHM < yatsiHM) {
                        long difference = yatsiHM - currentHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(difference),
                                TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(difference)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    } else if (currentHM > yatsiHM) {
                        long difference = yirmi4sHM - currentHM;

                        long diffs = difference + imsakHM;

                        String kalanZaman = String.format(Locale.US,
                                "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(diffs),
                                TimeUnit.MILLISECONDS.toMinutes(diffs) - TimeUnit.HOURS.toMinutes(
                                        TimeUnit.MILLISECONDS.toHours(diffs)), kalanSaniye);

                        txttimer.setText(kalanZaman);
                    }
                }
            }
            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                txttimer.setText("00:00:00");
                start();
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

    public void objectDecleration(){

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


    }

    public void navBar(){
        ltyAyet = (LinearLayout)findViewById(R.id.lytAyet);
        LinearLayout ltyHadis = (LinearLayout) findViewById(R.id.lytHadis);
        LinearLayout ltyDua = (LinearLayout) findViewById(R.id.lytDua);
        LinearLayout ltyAyarlar = (LinearLayout)findViewById(R.id.lytAyarlar);
        ltyAyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Ayet.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_right_in, R.anim.anim_left_out);
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

    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keycode, event);
    }



}
