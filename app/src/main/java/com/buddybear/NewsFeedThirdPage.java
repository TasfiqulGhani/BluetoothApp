package com.buddybear;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class NewsFeedThirdPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_third_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);



        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(NewsFeedThirdPage.this, NewsFeedFirstPage.class);
                startActivity(i2);
            }
        });

        BottomThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k=new Intent(NewsFeedThirdPage.this,GamePartFirstPage.class);
                startActivity(k);
            }
        });


    }

}