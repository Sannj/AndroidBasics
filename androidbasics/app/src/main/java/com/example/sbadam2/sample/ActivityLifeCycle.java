package com.example.sbadam2.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ActivityLifeCycle extends AppCompatActivity {

    String msg = "Android : ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(msg, "onCreate() is triggered");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(msg, "onStart() is triggered");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(msg, "onResume() is triggered");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(msg,"onPause triggered");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(msg,"onStop() triggered");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(msg,"onDestroy triggered");
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, FirstActivity.class);
        startActivity(i);
    }

}
