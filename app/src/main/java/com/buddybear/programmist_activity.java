package com.buddybear;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class programmist_activity extends AppCompatActivity {

    ImageButton back_btn;
    TextView Tv;

    String first = "Kui palju ja kuidas sa tegelikult enda lapsega koos aega veedad? Kui teed, tee täisväärtuslikult!\n\nSõber Karu mobiilirakendus on tööriist lapsevanemale, mis suunab lapsega veedetud aega teadlikult paremini planeerima ja täisväärtuslikult kasutama. Seeläbi õpetab Sõber Karu sulle, kuidas oma lapse arengut loovalt toetada ja aidata tal kasvada heaks kaaslaseks.";
    String second = "Sõber Karu on kiusamist ennetava tõenduspõhise metoodika „Kiusamisest vabaks!“ sümbol, kõikide laste ühine sõber, lohutaja ja vahendaja. 2016. aastaks on Sõber Karu tuttav 439 lasteaia ja 81 kooli lastele ja nende vanematele. Seega on tegemist tugevat sõnumit kandva tuttava ja turvalise tegelasega, kelle abil kõnetada nii lapsi kui ka täiskasvanuid.\n\nTäiskasvanud vastutavad lastele sotsiaalsete suhete õpetamise eest, seega on oluline, et vanemad oleksid ise teadlikud ning igal hetkel oma lapsele heaks eeskujuks.\n\nVaata rohkem: www.kiusamisestvabaks.ee ";
    String third = "„Kiusamisest vaba lasteaed ja kool“ on MTÜ Lastekaitse Liidu projekt ning vastab ühingu " +
            "tegevuse põhieesmärgile – lapse õiguste tagamisele ja lapsesõbraliku ühiskonna " +
            "kujundamisele. \n" +
            "\n" +
            "Vanemad on need, kellel on esmane kohustus last hoida, kaitsta ning tagada tema eakohane ja " +
            "igakülgne areng. Last tuleb kaitsta nii vaimse kui ka füüsilise vägivalla, hooletussejätmise ja " +
            "muude ohtude eest. \n" +
            "\n" +
            "Et laps ei satuks kiusajaks, kiusatavaks ega jääks ka passiivse kõrvaltvaataja rolli, peab ta " +
            "õppima positiivseid sotsiaalseid oskusi. Lapsel on õigus kiusamisvabale elule ning hooliv ja " +
            "teadlik vanem saab teda selles toetada, õpetades talle olulisi põhiväärtusi – julgust, hoolivust, " +
            "sallivust ja austust.\n" +
            "\n" +
            "Rohkem laste õigustest: www.lastekaitseliit.ee";
    String fourth = "Kiusamine ei puuduta ainult ohvrit ja kiusajat, vaid on rühmafenomen. Kiusamismudelis on roll ka kaasajooksikutel ja passiivsetel pealtvaatajatel.\n\nKiusamine on süstemaatiline. Tegu on terve hulga suuremate ja väiksemate käitumisviisidega, mis kõik annavad märku, et \"sa ei kuulu siia\". Kiusamine leiab aset inimkoosluses, kust ohver ei saa ära tulla (sealhulgas kool, lasteaed).Kiusamine võib olla nii füüsiline, verbaalne kui ka seotud sotsiaalsete suhetega. Kiusamine ei ole vältimatu, seda saab ennetada ja vähendada. Kiusamise ennetamine nõuab kõigi laste ja täiskasvanute panust. Heaks kaaslaseks olemise oskus on õpitav. Sotsiaalsete suhete õpetamise eest vastutavad eeskätt vanemad, kes vajavad selleks omakorda teadmisi ja vahendeid. Selleks oleme loonud „Kiusamisest vabaks!“ metoodika abil Sõber Karu mobiilirakenduse, mis aitab tõsta vanema teadlikkust kiusamisvaba elutee kujundamisel." ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programmist_layout);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

        back_btn = (ImageButton) findViewById(R.id.back);
        Tv = (TextView) findViewById(R.id.tv);
        Tv.setTypeface(font);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        if(id.equals("one")){
            Tv.setText(first);
            Linkify.addLinks(Tv, Linkify.ALL);
        }
        else if(id.equals("two")){
            Tv.setText(second);
            Linkify.addLinks(Tv, Linkify.ALL);
        }

        else if(id.equals("three")){
            Tv.setText(third);
            Linkify.addLinks(Tv, Linkify.ALL);
        }
        else if(id.equals("four")){
            Tv.setText(fourth);
            Linkify.addLinks(Tv, Linkify.ALL);
        }






    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }


}
