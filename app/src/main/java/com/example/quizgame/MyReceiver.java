package com.example.quizgame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "Receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
       String action = intent.getAction();
       if(action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)){
           int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
           int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
           int percentage = level* 100/scale;
                if (percentage<15){
                    Toast toastBattery = Toast.makeText(context, "You have only "+ percentage + " % Battery .Dont play ", Toast.LENGTH_LONG);
                    View toastView = toastBattery.getView();
                    toastView.setBackgroundResource(R.drawable.toast_drawable);

                    toastBattery.show();
                }

       }








    }
}