package com.example.android.wtmusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    private Button musicShop;
    private Button musicList;
    private Button Reproducer;
    private Button Login;
    private Button payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicList = (Button) findViewById(R.id.button5);
        musicShop = (Button) findViewById(R.id.button1);
        Reproducer = (Button) findViewById(R.id.button3);
        Login = (Button) findViewById(R.id.button4);
        payment = (Button) findViewById(R.id.button2);


        musicList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songlistintent = new Intent(MainActivity.this, songList.class);
                startActivity(songlistintent);

            }
        });


        musicShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent musicShopIntent = new Intent(MainActivity.this, musicShop.class);
                startActivity(musicShopIntent);
            }
        });


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentIntent = new Intent(MainActivity.this, settings.class);
                startActivity(paymentIntent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
            }
        });

        Reproducer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent producerIntent = new Intent(MainActivity.this, Producer.class);
                startActivity(producerIntent);



            }
        });


    }
}