package com.buddybear;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class page_setting_one extends AppCompatActivity {

    ImageButton back_btn;
    TextView Tv;

    String first = "Team NSU Spark is a team formed by students and fresh graduates of North South University Dhaka,Bangladesh.\n" +
            "\n" +
            "Team is currently working in various fields of science and technology. Team has contributed in many projects, research works. Team spark developed some cool and efficient robots like multipurpose robot, Bomb defuser robot,SumoBot,Rescue robot and many more. Team is also working in solving various problems of country by making various electrical projects. For example Smart Wheel Chair. A wheel chair which can be controlled by patient himself using mobile, brain and joystick. Team spark currently working on Mars mission projects for example Mars rover. They are developing a Mars rover for this research purpose and also one of the participants of European Rover Challenge 2016. Team spark developed a virtual reality tool for astronauts when they participated in Nasa Space Apps Challenge 2016.\n" +
            "\n\n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programmist_layout);

        back_btn = (ImageButton) findViewById(R.id.back);
        Tv = (TextView) findViewById(R.id.tv);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

            Tv.setText(first);
            Tv.setTypeface(font);
            Linkify.addLinks(Tv, Linkify.ALL);







    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }


}
