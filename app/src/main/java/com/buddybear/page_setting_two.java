package com.buddybear;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class page_setting_two extends AppCompatActivity {



    ImageButton back_btn;
    TextView Tv;

    String first = "Sõber Karu mobiilirakenduse abil saate kasutada oma nutiseadet abivahendina vanemaks olemise keerulisel ja võimalusterohkel teel. \n" +
            "\n" +
            "Mobiilirakendus on jaotatud kolmeks osaks: \n\n" +
            "-   Teadmiste osas on võimalik lugeda valikut praktiliste näpunäidetega kasvatusalastest artiklitest ja vaadata videosid nõuannetega lapse toetamiseks. Samuti saab kasutaja teadmisi rakendusega seotud oluliste märksõnade kohta. \n" +
            "\n-   Eesmärkide osa annab vanemale valiku ideid tegevusteks, mida lapse sotsiaalsete oskuste arendamiseks koos ette võtta ning aitab seatud eesmärke meeles hoida. \n" +
            "\n-   Mängu osa suunab last ja vanemat üheskoos argiseid askeldusi läbi mängulise tegevuse märkama ja mõtestama. Lihtsates asjades peituvad sageli suured mõtted ja võimalused, tundke rõõmu nende otsimisest ja leidmisest. \n" +
            "\nRakenduse eesmärkide seadmise ja mängu osa on võimalik kasutada internetiühenduseta. See ühildub nii iOS seadmete kui Androidi mudelitega.\n";


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
