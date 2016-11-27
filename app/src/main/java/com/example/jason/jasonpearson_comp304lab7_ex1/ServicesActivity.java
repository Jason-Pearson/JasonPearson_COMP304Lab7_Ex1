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

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
    }
    public void onResume()
    {
        super.onResume();
        //This needs to be in the activity that will end up receiving the broadcast
        registerReceiver(receiver, new IntentFilter("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.STRING"));

    }
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MySimpleService.class));
    }

    public void stopService(View view) {
        //TextView textView = (TextView) findViewById(R.id.textview); //Oh...duh lol, there is where it should be..
        //textView.setText("Stopped Service :(");

        stopService(new Intent(getBaseContext(),
                MySimpleService.class));
    }


    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            TextView textView = (TextView) findViewById(R.id.textview); //Oh...duh lol, there is where it should be..
            String action = intent.getAction();
            if (action.equals(MySimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.STRING"); //Don't need to add the .STRING part, I just did it for tests
                textView.setText(info);
            }
            /*if (action.equals(MySimpleService.INFO_INT)) {
                int info = intent.getIntExtra("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.INT", 21); //Integer.toString(info2) - for setText - what's the point of castin gto String if you're testing displaying diff. data  types?
                textView.setText(info);
            }*/
            /*if (action.equals(MySimpleService.INFO_DOUBLE)) {
                double info = intent.getDoubleExtra("com.example.jason.jasonpearson_comp304lab7_ex1.Services.INFO_UPDATE.DOUBLE", 21.99); //+ "/n" + Integer.toString(info2) - for setText - what's the point of castin gto String if you're testing displaying diff. data  types?
                textView.setText(info); //doesn't accept Double variable in setText method...
            }*/
        }

    };

}
