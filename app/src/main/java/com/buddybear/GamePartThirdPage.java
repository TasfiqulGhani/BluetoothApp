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

public class GamePartThirdPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    ImageButton setting_btn;
    String despBig = "aga Väike Karu oli samuti väga tubli! Et ka Väike Karu saaks sama suureks ja tugevaks, saab Suur Karu teda alati aidata ning olla talle parimaks võimalikuks eeskujuks!";
    String despMid = "Koos tegutsemine ja oluliste teemade üle arutlemine aitab mõlemal kasvada sallivaks, austavaks, julgeks ja hoolivaks! Jätkake samas vaimus!";
    String despSmall = "aga Suur Karu oli samuti väga tubli! Väikese Karuga koos tegutsemine aitab Suurel Karul maailma avaramalt näha! Nautige ühist avastusretke ning olge avatud üksteiselt õppima!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part_third_page);

        String winner = getIntent().getStringExtra("key_name");
        TextView txt = (TextView) findViewById(R.id.question_frag123);
        txt.setText(winner);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

        TextView tv = (TextView) findViewById(R.id.textView4);


        if(winner.equals("Seekord võitis Suur Karu…!")){
            tv.setText(despBig);
        }
        else if(winner.equals("Nii Väike kui Suur Karu on olnud tublid! (Viik)")){
            tv.setText(despMid);
        }
        else {
            tv.setText(despSmall);
        }

        tv.setTypeface(font);


        Button alusta = (Button) findViewById(R.id.alusta);
        alusta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(GamePartThirdPage.this, GamePartFirstPage.class);
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


                Intent i = new Intent(GamePartThirdPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });




        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartThirdPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin2 = (RelativeLayout) findViewById(R.id.linBottomTwo);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(GamePartThirdPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);


        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartThirdPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        BottomTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(GamePartThirdPage.this, TodoFirstPage.class);

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