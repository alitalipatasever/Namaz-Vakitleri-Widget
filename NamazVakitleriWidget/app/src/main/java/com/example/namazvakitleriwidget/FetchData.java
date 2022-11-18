package com.example.namazvakitleriwidget;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    String strImsak,strGunes,strOgle,strIkindi,strAksam,strYatsi,strTarih, strMiladiTarihKisa, strAyinSekliURL;
    String[] dizi;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://ezanvakti.herokuapp.com/vakitler/9206");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String strDate = dateFormat.format(date);
            //String strDate = "20.12.2021";
            //int daynum = Integer.parseInt(strDate);


            dizi = new String[100];

            JSONArray JA = new JSONArray(data);

            for(int i =0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                strMiladiTarihKisa = ""+ JO.get("MiladiTarihKisa");

                if(strDate.equals(strMiladiTarihKisa)){
                    strTarih = ""+JO.get("MiladiTarihUzun")+"\n"+JO.get("HicriTarihUzun");
                    strImsak = ""+JO.get("Imsak");
//                MainActivity.fetchImsak = ""+JO.get("Imsak");
//                NewAppWidget.newData = ""+JO.get("Imsak");
                    strGunes = ""+JO.get("Gunes");
                    strOgle = ""+JO.get("Ogle");
                    strIkindi = ""+JO.get("Ikindi");
                    strAksam = ""+JO.get("Aksam");
                    strYatsi = ""+JO.get("Yatsi");
                    strAyinSekliURL = ""+JO.get("AyinSekliURL");

                    MainActivity.fetchTarih = ""+JO.get("MiladiTarihUzun")+"\n"+JO.get("HicriTarihUzun");
                    MainActivity.fetchImsak = strImsak;
                    MainActivity.fetchGunes = strGunes;
                    MainActivity.fetchOgle = strOgle;
                    MainActivity.fetchIkindi = strIkindi;
                    MainActivity.fetchAksam = strAksam;
                    MainActivity.fetchYatsi = strYatsi;
                    MainActivity.fetchAyinSekliURL = strAyinSekliURL;

                    NewAppWidget.fetchTarih = ""+JO.get("MiladiTarihUzun")+"  |  "+JO.get("HicriTarihUzun");
                    NewAppWidget.fetchImsak = strImsak;
                    NewAppWidget.fetchGunes = strGunes;
                    NewAppWidget.fetchOgle = strOgle;
                    NewAppWidget.fetchIkindi = strIkindi;
                    NewAppWidget.fetchAksam = strAksam;
                    NewAppWidget.fetchYatsi = strYatsi;

//                    dizi[i]=strTarih+","+strImsak+","+strGunes+","+strOgle+","+strIkindi+","+strAksam+","+strYatsi;
//                    MainActivity.dizi[i]=dizi[i];
                }

//                singleParsed =JO.get("MiladiTarihUzun")+" | "+JO.get("Imsak")+" | "+JO.get("Gunes")
//                +" | "+JO.get("Ogle")+" | "+JO.get("Ikindi")+" | "+JO.get("Aksam")+" | "+JO.get("Yatsi")+"\n";
//                dataParsed = dataParsed + singleParsed;

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.imsak.setText(this.strImsak);
        MainActivity.gunes.setText(this.strGunes);
        MainActivity.ogle.setText(this.strOgle);
        MainActivity.ikindi.setText(this.strIkindi);
        MainActivity.aksam.setText(this.strAksam);
        MainActivity.yatsi.setText(this.strYatsi);
        MainActivity.tarih.setText(this.strTarih);
        MainActivity.fetchAyinSekliURL.replace("",strAyinSekliURL);

        //AllTimes.topluvakitler.setText(dataParsed);


    }

}