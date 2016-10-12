package com.example.sbadam2.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }

    @Override
    public void finish(){
        Intent i = new Intent();
        i.putExtra("returnValue1","returnValue1");
        setResult(101,i);
        super.finish();
    }
}
