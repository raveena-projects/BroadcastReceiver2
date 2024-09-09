package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.TextView;

public class BatteryStatusReceiver extends BroadcastReceiver {

    private TextView chargingStatus;

    public BatteryStatusReceiver(TextView chargingStatus){
        this.chargingStatus = chargingStatus;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;
        BatteryManager batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        int batteryPercentage = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        chargingStatus.setText(isCharging ? "Charging" : "Not charging");
        System.out.println("batteryPercentage"+batteryPercentage);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
        int battery = (int)((level/scale)*100);

        //BATTERY_PROPERTY_CAPACITY

    }
}
