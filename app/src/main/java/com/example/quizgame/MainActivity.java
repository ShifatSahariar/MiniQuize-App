package com.example.quizgame;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MyReceiver brodcastreceiver = new MyReceiver();
    IntentFilter intentFilter =new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    String topicname="";
    LinearLayout java,html,css,kotlin;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        java =findViewById(R.id.javalayout);
        html =findViewById(R.id.htmllayout);
        css =findViewById(R.id.csslayout);
        kotlin =findViewById(R.id.kotlinlayout);
        final Button startbtn =findViewById(R.id.startbtn);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="java";
                java.setBackgroundResource(R.drawable.greenborderhiglight);
                html.setBackgroundResource(R.drawable.round);
                css.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);

            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="html";
                java.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.greenborderhiglight);
                css.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);
            }
        });

        css.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="css";
                java.setBackgroundResource(R.drawable.round);
               css.setBackgroundResource(R.drawable.greenborderhiglight);
               html.setBackgroundResource(R.drawable.round);
                kotlin.setBackgroundResource(R.drawable.round);
            }
        });

        kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicname="kotlin";
                kotlin.setBackgroundResource(R.drawable.greenborderhiglight);
                css.setBackgroundResource(R.drawable.round);
                html.setBackgroundResource(R.drawable.round);
                java.setBackgroundResource(R.drawable.round);

            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (topicname.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Choose a topic first", Toast.LENGTH_SHORT).show();

                }else {
                    Intent intent = new Intent (MainActivity.this,game.class);
                    intent.putExtra("topicname",topicname);
                    startActivity(intent);
                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();


        //Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registerReceiver(brodcastreceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(brodcastreceiver);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("save called",topicname);
        outState.putString("Selected Option", topicname);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        topicname = savedInstanceState.getString("Selected Option");
        switch (topicname) {
            case "html":
                html.setBackgroundResource(R.drawable.greenborderhiglight);
                break;
            case "css":
                css.setBackgroundResource(R.drawable.greenborderhiglight);
                break;
            case "kotlin":
                kotlin.setBackgroundResource(R.drawable.greenborderhiglight);
                break;
            case "java":
                java.setBackgroundResource(R.drawable.greenborderhiglight);
                break;

        }


    }

}

