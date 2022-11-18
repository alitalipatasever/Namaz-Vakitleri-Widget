package com.example.namazvakitleriwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {
    public static TextView imsak, gunes, ogle, ikindi, aksam, yatsi, tarih;
    public static String fetchTarih,fetchImsak,fetchGunes,fetchOgle,fetchIkindi,fetchAksam,fetchYatsi;

    String urlMoon ="https://namazvakti.diyanet.gov.tr/images/d1.gif";
    public static ImageView imgMoon;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int widgetId : appWidgetIds) {

            // Create an Intent to launch MainActivity
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,
                    0, intent, 0);

            // Create an Intent to Refresh MyWidgetProvider
            Intent intent1 = new Intent(context, NewAppWidget.class);
            intent1.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent1 = PendingIntent.getBroadcast(context,
                    0, intent1, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button and imageview
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                    R.layout.new_app_widget);

            //set the random text
            //remoteViews.setTextViewText(R.id.txtimsak, stringText);
            remoteViews.setTextViewText(R.id.txttarih, fetchTarih);
            remoteViews.setTextViewText(R.id.txtimsak, fetchImsak);
            remoteViews.setTextViewText(R.id.txtgunes, fetchGunes);
            remoteViews.setTextViewText(R.id.txtogle, fetchOgle);
            remoteViews.setTextViewText(R.id.txtikindi, fetchIkindi);
            remoteViews.setTextViewText(R.id.txtaksam, fetchAksam);
            remoteViews.setTextViewText(R.id.txtyatsi, fetchYatsi);

            //Picasso.with(context).load(urlMoon).into(imgMoon);


            //set pending intent1 to action button to refresh Widget
//            remoteViews.setOnClickPendingIntent(R.id.btnyenile, pendingIntent1);

//            //set the pending intent to open MainActivity
//            remoteViews.setOnClickPendingIntent(R.id.app_widget_imageView, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }

    public static String newData;
}