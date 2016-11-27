package com.example.jason.jasonpearson_comp304lab7_ex1;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.ServiceConnection;


public class ServicesActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
//
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), MySimpleService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                MySimpleService.class));
    }

}
