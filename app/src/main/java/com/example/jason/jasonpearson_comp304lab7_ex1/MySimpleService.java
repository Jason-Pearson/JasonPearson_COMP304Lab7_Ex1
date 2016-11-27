package com.example.jason.jasonpearson_comp304lab7_ex1;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MySimpleService extends Service{

    public static final String INFO_INTENT =
            "com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.STRING"; //replace with your package name - DONT NEED TO ADD .STRING part, I did it for testing
    /*public static final String INFO_INT =
            "com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.INT";
    public static final String INFO_DOUBLE =
            "com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.DOUBLE";*/


    //int integer = 21;
    //double aDouble = 21.999999999;
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.

        //Add Intent Object Reference - for Extras to broadcast when starting Service
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT, "Hello There! I come from the land down under!");
        /*broadcastIntent.setAction(INFO_INT);
        broadcastIntent.putExtra(INFO_INT, integer);
        broadcastIntent.setAction(INFO_DOUBLE);
        broadcastIntent.putExtra(INFO_DOUBLE, aDouble);*/
        this.sendBroadcast(broadcastIntent);

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}
