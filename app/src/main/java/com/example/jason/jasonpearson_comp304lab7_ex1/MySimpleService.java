package com.example.jason.jasonpearson_comp304lab7_ex1;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MySimpleService extends Service{

    public static final String INFO_INTENT =
            "com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE"; //replace with your package name

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.

        //Add Intent Object Reference - for String Extras
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT, "Hello There");
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
