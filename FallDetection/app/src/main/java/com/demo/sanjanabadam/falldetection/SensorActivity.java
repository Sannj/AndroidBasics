package com.demo.sanjanabadam.falldetection;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SensorActivity extends Service implements SensorEventListener{
    private SensorManager accelManager;
    private Sensor accel;
    float indexz[] = new float[128];
    int index = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        accelManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = accelManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        accelManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public SensorActivity() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor mySensor = event.sensor;
        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
        indexz[index] = event.values[2];
            index++;
            if(index > 127){
                index = 0;
                accelManager.unregisterListener(this);
                callFallDetection();
                accelManager.registerListener(this,accel,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    public void callFallDetection(){
        float prev = 10;
        float curr = 0;
        for(int i = 11; i < 128;i++){
            curr = indexz[i];
            if(Math.abs(prev - curr) > 10){
                Toast.makeText(this, "Fall detected", Toast.LENGTH_LONG).show();
                sendSMS();
            }
        }
    }

    public void sendSMS(){
        String phoneNumber = ("4808684852");
        Toast.makeText(SensorActivity.this, phoneNumber, Toast.LENGTH_LONG).show();
        String message = "Fall detected";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber,null,message,null,null);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
