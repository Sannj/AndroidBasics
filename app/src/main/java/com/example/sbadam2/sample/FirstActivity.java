package com.example.sbadam2.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void showIntentExample(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void startActivityForResult(View view){
        Intent i = new Intent(this, NewActivity.class);
        i.putExtra("Value1","Value1");
        startActivityForResult(i,100);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i){
        if(resultCode == 101 && requestCode == 100){
            Toast.makeText(this, i.getExtras().getString("returnValue1"),Toast.LENGTH_SHORT).show();
        }
    }

    public void activityLifeCycle(View view){
        Intent i = new Intent(this, ActivityLifeCycle.class);
        startActivity(i);
    }
}
