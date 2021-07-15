package com.example.androidjava;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * OnCreate: this method is called as part of the Android Lifecycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Oncreate event
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View v){
        Toast.makeText(this, "List Page", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }

}
