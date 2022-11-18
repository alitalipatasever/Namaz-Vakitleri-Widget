package com.example.namazvakitleriwidget;
import android.os.AsyncTask;

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
import java.util.Calendar;
import java.util.Date;

public class FetchDataWidget extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    String strImsak,strGunes,strOgle,strIkindi,strAksam,strYatsi,strTarih;

    String[] vakitler;
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
            DateFormat dateFormat = new SimpleDateFormat("dd");
            String strDate = dateFormat.format(date);
            int daynum = Integer.parseInt(strDate);

            int[] dizi;
            dizi = new int[31];
            int value=15;
            for (int i=0; i<=30; i++){
                dizi[i]=value;
                value++;
                if(value==32){
                    value=1;
                }
            }
            int temp=0;
            for (int i=0; i<=30; i++){
                if(dizi[i]==daynum){
                    temp=i;
                }
            }
            vakitler = new String[29];
            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(temp);
                strTarih = ""+JO.get("MiladiTarihUzun")+" | "+JO.get("HicriTarihUzun");
                strImsak = ""+JO.get("Imsak");
                strGunes = ""+JO.get("Gunes");
                strOgle = ""+JO.get("Ogle");
                strIkindi = ""+JO.get("Ikindi");
                strAksam = ""+JO.get("Aksam");
                strYatsi = ""+JO.get("Yatsi");

                //vakitler[i]={strTarih,strImsak};

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

//        NewAppWidget.imsak.setText(this.strImsak);
//        NewAppWidget.gunes.setText(this.strGunes);
//        NewAppWidget.ogle.setText(this.strOgle);
//        NewAppWidget.ikindi.setText(this.strIkindi);
//        NewAppWidget.aksam.setText(this.strAksam);
//        NewAppWidget.yatsi.setText(this.strYatsi);
//        NewAppWidget.tarih.setText(this.strTarih);

        //AllTimes.topluvakitler.setText(dataParsed);


    }

}