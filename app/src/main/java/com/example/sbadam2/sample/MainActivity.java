package com.example.sbadam2.sample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
    }

    
    //Explicit intent
    public void clickedExplicit(View view){
        Intent i = new Intent(this, NewActivity.class);
        i.putExtra("value1","This is value1");
        startActivity(i);
    }


    //Implicit activity to open a web browser
    //using the implicit value - Intent.ACTION_VIEW
    public void clickedImplicit(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i);
    }
}
