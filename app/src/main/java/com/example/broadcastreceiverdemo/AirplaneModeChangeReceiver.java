package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    private View view;
    public AirplaneModeChangeReceiver(View view){
        this.view = view;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())){
            boolean isAirplaneModeOn = Settings.System.getInt(
                    context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON,0) != 0;
            if(isAirplaneModeOn){
//                Snackbar.make(context.getApplicationContext(),)
                System.out.println("Airplane Mode on");
                Toast.makeText(view.getContext(), "Airplane Mode Enabled",Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(view.getContext(), "Airplane Mode Disabled",Toast.LENGTH_LONG).show();
            }

        }
    }
}
