package com.example.dchen.assignment10;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private int count1;
    private int count2;
    private int count3;
    private int count4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        text1 = (TextView) findViewById(R.id.tv1);
        text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count1++;
                Toast.makeText(Main2Activity.this, "Text 1 Pressed " + count1 + " Times", Toast.LENGTH_SHORT).show();
            }
        });
        text2 = (TextView) findViewById(R.id.tv2);
        text2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count2++;
                Toast.makeText(Main2Activity.this, "Text 2 Pressed " + count2 + " Times", Toast.LENGTH_SHORT).show();
            }
        });
        text3 = (TextView) findViewById(R.id.tv3);
        text3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count3++;
                Toast.makeText(Main2Activity.this, "Text 3 Pressed " + count3 + " Times", Toast.LENGTH_SHORT).show();
            }
        });
        text4 = (TextView) findViewById(R.id.tv4);
        text4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count4++;
                Toast.makeText(Main2Activity.this, "Text 4 Pressed " + count4 + " Times", Toast.LENGTH_SHORT).show();
            }
        });

        Button closeButton = (Button) findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
