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

public class FetchDataAllTimes extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    String strImsak,strGunes,strOgle,strIkindi,strAksam,strYatsi,strTarih;
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

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i < JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                strTarih = ""+JO.get("MiladiTarihUzun");
                strImsak = ""+JO.get("Imsak");
                strGunes = ""+JO.get("Gunes");
                strOgle = ""+JO.get("Ogle");
                strIkindi = ""+JO.get("Ikindi");
                strAksam = ""+JO.get("Aksam");
                strYatsi = ""+JO.get("Yatsi");

                singleParsed =JO.get("MiladiTarihKisa")+"  "+JO.get("Imsak")+"  "+JO.get("Gunes")
                +"  "+JO.get("Ogle")+"  "+JO.get("Ikindi")+"  "+JO.get("Aksam")+"  "+JO.get("Yatsi")+"\n";
                dataParsed = dataParsed + singleParsed;

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

//        AllTimes.Aimsak.setText(this.strImsak);
//        AllTimes.Agunes.setText(this.strGunes);
//        AllTimes.Aogle.setText(this.strOgle);
//        AllTimes.Aikindi.setText(this.strIkindi);
//        AllTimes.Aaksam.setText(this.strAksam);
//        AllTimes.Ayatsi.setText(this.strYatsi);
//        AllTimes.Atarih.setText(this.strTarih);

        AllTimes.topluvakitler.setText(dataParsed);


    }

}