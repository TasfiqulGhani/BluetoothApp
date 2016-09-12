package com.buddybear;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class TodoThirdPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    ImageButton setting_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_third_page);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setTypeface(font);

        TextView tv1 = (TextView) findViewById(R.id.textView3);
        String winner = getIntent().getStringExtra("percent");

        if (winner.equals("100")){
            tv1.setText("Congratulations 100 %");
            tv.setText("");
        }
        else{
            tv1.setText("Congratulations "+winner+"%");
            tv.setText("");
        }

        Button lisamine = (Button) findViewById(R.id.lisamine);
        lisamine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                getApplicationContext().deleteDatabase("Todo");


                Intent i = new Intent(TodoThirdPage.this, TodoFirstPage.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();


            }
        });


        Button fb = (Button) findViewById(R.id.facebookBTN);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFB();
            }
        });

        Button tweet = (Button) findViewById(R.id.twitterBTN);
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTwitter();
            }
        });

        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TodoThirdPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });


        getApplicationContext().deleteDatabase("Todo");



        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoThirdPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin3 = (RelativeLayout) findViewById(R.id.linBottomThree);
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoThirdPage.this, GamePartFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);



        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2=new Intent(TodoThirdPage.this,NewsFeedFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        BottomThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k=new Intent(TodoThirdPage.this,GamePartFirstPage.class);
                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });


    }

    public void callFB(){
        String urlToShare = "http://kiusamisestvabaks.ee/soberkaruapp/";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
// intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // NB: has no effect!
        intent.putExtra(Intent.EXTRA_TEXT, urlToShare);

// See if official Facebook app is found
        boolean facebookAppFound = false;
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                intent.setPackage(info.activityInfo.packageName);
                facebookAppFound = true;
                break;
            }
        }

// As fallback, launch sharer.php in a browser
        if (!facebookAppFound) {
            String sharerUrl = "https://www.facebook.com/sharer/sharer.php?u=" + urlToShare;
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
        }

        startActivity(intent);
    }
    public void callTwitter(){
        String tweetUrl = String.format("https://twitter.com/intent/tweet?text=%s&url=%s",
                urlEncode("Tweet text"),
                urlEncode("http://kiusamisestvabaks.ee/soberkaruapp/"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl));

// Narrow down to official Twitter app, if available:
        List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {
            if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                intent.setPackage(info.activityInfo.packageName);
            }
        }

        startActivity(intent);
    }

    public static String urlEncode(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {

            throw new RuntimeException("URLEncoder.encode() failed for " + s);
        }
    }



}