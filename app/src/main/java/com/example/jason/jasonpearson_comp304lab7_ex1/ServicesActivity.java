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
import android.widget.TextView;
import android.widget.Toast;
import android.content.ComponentName;
import android.os.IBinder;
import android.content.ServiceConnection;


public class ServicesActivity extends Activity {
    //TextView textView = (TextView) findViewById(R.id.textview);

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TextView textView = (TextView) findViewById(R.id.textview); //-put TextView in onCreate method?

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }
    //Do I call this method at all?...yes?...nah?
    public void onResume()
    {
        super.onResume();
        //This needs to be in the activity that will end up receiving the broadcast
        registerReceiver(receiver, new IntentFilter("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE"));

    }
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MySimpleService.class));
        //onResume();
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                MySimpleService.class));
    }


    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(MySimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE");
                //textView.setText(info);
            }
        }

    };

}
