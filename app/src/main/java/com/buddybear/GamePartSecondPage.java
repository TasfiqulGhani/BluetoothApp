package com.buddybear;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Stack;

public class GamePartSecondPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    int first_question = 0;
    int progress_image=1;
    Stack myStack_question = new Stack();
    Stack myStack_description = new Stack();
    int j = 0;
    TextView txt,txt1;
    boolean child = false;
    boolean parent = false;
    ImageButton child_yes,child_no,parent_yes,parent_no,progress;
    Button  id;
    int mark = 0;
    String data;
    int que_question;
    // int que_question = selected_quetion;
    int parent_score = 0;
    int child_score =0;
    int parents_ans =0;
    int child_ans = 0;
    String winner;
    ImageButton setting_btn;

    String questions [] = {"Kas sa oled hiljuti sõpra/pereliiget/tuttavat aidanud? ",
            "Kas sa tead, kes on sinu naabrid?",
            "Kas sa nägid täna kedagi naermas?",
            "Kas sa oled täna kedagi tunnustanud?",
            "Kas sa oled hiljuti mõne uue oskuse õppinud?",
            "Kas sa oled küsinud pereliikmelt/tuttavalt, kuidas tema päev möödus?",
            "Kas sa oled täna mõelnud mõnele heateole, mida sooviksid teostada?",
            "Kas sa oled täna oma lähedastele öelnud, et sa hoolid neist?",
            "Kas sa oled teinud midagi keskkonna säästmiseks?",
            "Kas sa oled lähiajal arutlenud päevakajaliste uudiste üle?",
            "Kas sa oled täna värskes õhus liikunud?",
            "Kas sa tead oma vanavanemate nimesid?",
            "Kas oled hiljuti kodus laulnud?",
            "Kas sa oled hiljuti midagi meisterdanud?",
            "Kas oled hiljuti liftiga sõitmise asemel trepist käinud?",
            "Kas oled täna torni ehitanud?",
            "Kas oled hiljuti kodus tantsinud?",
            "Kas oled täna kedagi tänanud?",
            "Kas sa tead, mis paistab sinu köögiaknast?",
            "Kas sa tead, mida tähendavad sallivus, hoolivus, julgus, austus?"};

    String description [] = {"Arutlege edasi - Kuidas sa teda aitasid? Kuidas sa ennast tundsid, kui sa teda aitasid? Miks on oluline teisi inimesi aidata? Kes sind aidanud on? Kuidas sa ennast tundsid, kui sind aidati?",
            "Arutlege edasi - Millal sa viimati oma naabritega suhtlesid? Kuidas võiksid oma naabritega suhtlust alustada/arendada? Miks on oluline enda lähedal elavaid inimesi teada/tunda?",
            "Arutlege edasi - Kas sa nägid kedagi naermas? Kuidas sa ennast tundsid kui nägid kedagi naermas? Kas sa tead, miks see inimene naeris? Mis sind naerma paneb? Kas sina oled täna naernud? Kuidas sa ennast naerdes tunned?",
            "Arutlege edasi - Miks on kiitus/tunnustamine oluline? Kuidas sa end peale kiitmist tundsid? Kuidas sa ennast tunned kui keegi sind kiidab? Milles eest võib kiita?",
            "Arutlege edasi - Millise oskuse sa õppisid? Kuidas saad seda oskust igapäevaelus kasutada? Kas oled seda oskust teistele õpetanud? Kuidas sa ennast tundsid kui selle oskuse selgeks said?",
            "Arutlege edasi – Mida toredat ja huvitavat sa oled kuulnud? Kas sa kuulsid midagi, mis tegi sind rõõmsaks? Kas sa kuulsid midagi, mis tegi sind kurvaks? Kuidas möödus sinu enda päev?",
            "Arutlege edasi – Mida peaksid tegema, et see teoks saaks? Milliseid heategusid sa oled varem teinud? Kuidas sa ennast tundsid kui sa tegid mõne heateo? Kuidas saaks veel heategusid teha? Miks on oluline heategusid teha?",
            "Arutlege edasi – Kuidas saab öelda, et hoolid kellestki? Kuidas saab sõnadeta näidata, et hoolid? Kellest sa hoolid? Miks on hoolimine oluline?",
            "Arutlege edasi  – Mis on keskkond? Miks on oluline mõelda keskkonna säästmisele? Kuidas saad kodus olles keskkonda säästa? Kuidas saad looduses viibides keskkonda säästa? Mis juhtub kui keskkonda ei säästeta?",
            "Arutlege edasi – Kuidas said uudistest teada (nt ajaleht, raadio, televisioon, internet, keegi rääkis)? Kas said uudistest teada midagi huvitavat? Kellega sa arutasid, mida uudisena kuulsid? Kas oled arutanud uudiseid lapsega/vanemaga?",
            "Arutlege edasi – Kuidas ja kui kaua viibisid täna värskes õhus? Mida sa tegid värskes õhus? Kas arvad, et viibisid värskes õhus piisavalt? Kas toas olles saab viibida värskes õhus? Miks on oluline viibida värskes õhus?",
            "Arutlege edasi – Millised olid vanavanemad lastena? Mida naljakat on su vanavanemad teinud? Mida vanavanematele meeldib teha? Millal viimati vanavanematega kohtusid? Miks on esivanemate tundmine oluline?",
            "Arutlege edasi – Kas toredam on laulda üksinda või teistega koos? Kuidas sa ennast lauldes tunned? Kas sulle meeldib teiste laulmist kuulata? Milline muusika sulle meeldib?",
            "Arutlege edasi – Kas meisterdades on olulisem tegevus või tulemus? Mis on sul hästi välja tulnud? Kas näitasid oma meisterdust kellelegi? Mida võiksid veel meisterdada?",
            "Arutlege edasi – Kas lihtsam on kõndida trepist üles või alla? Miks on liftiga sõitmise asemel parem käia trepist?",
            "Arutlege edasi - Mis on torni ehitamise juures põnev? Kuidas sa ennast tundsid kui torn kokku kukkus? Millest saab torni ehitada? Millest ei saa torni ehitada? Kas torni on toredam ehitada koos või üksi?",
            "Arutlege edasi – Kuidas sa ennast tantsides tunned? Kas sa oskad liikuda nagu kass, karu, jänes, või luik? Kas toredam on tantsida üksi või kellegagi koos? Kas tantsida saab ilma muusikata?",
            "Arutlege edasi – Kuidas sa ennast tantsides tunned? Kas sa oskad liikuda nagu kass, karu, jänes, või luik? Kas toredam on tantsida üksi või kellegagi koos? Kas tantsida saab ilma muusikata?",
            "Arutlege edasi – Kas köögiaknast paistab alati üks ja seesama vaade? Mis on akna taga erinevat suvel ja talvel? Kas sa saad muuta seda, mida sa aknast näed?",
            "Arutlege edasi – Miks on sallivus, hoolivus, julgus ja austus olulised? Milline on hea kaaslane? Kellelt võiksid saada rohkem teada sallivuse, hoolivuse, julguse ja austuse kohta?"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part_second_page);

        setting_btn = (ImageButton) findViewById(R.id.settings_button);
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(GamePartSecondPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });

        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartSecondPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin2 = (RelativeLayout) findViewById(R.id.linBottomTwo);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(GamePartSecondPage.this, TodoFirstPage.class);

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
                Intent i2 = new Intent(GamePartSecondPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        BottomTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(GamePartSecondPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();

            }
        });


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");
        data = getIntent().getStringExtra("key_name2");
        que_question = Integer.parseInt(data);
        txt = (TextView)findViewById(R.id.question_frag2);
        txt.setTypeface(font);
        txt1 = (TextView)findViewById(R.id.description_frag2);
        txt1.setTypeface(font);
        mark = RandomNumber();
        first_question = mark;
        txt.setText(questions[mark]);
        txt1.setText(description[mark]);
        myStack_question.push(questions[mark]);
        myStack_description.push(description[mark]);

        child_no = (ImageButton)findViewById(R.id.button_no_child);
        child_yes = (ImageButton)findViewById(R.id.button_yes_child);
        parent_no = (ImageButton)findViewById(R.id.button_no_parent);
        parent_yes = (ImageButton)findViewById(R.id.button_yes_parent);
        progress = (ImageButton)findViewById(R.id.progress_button);
        id = (Button)findViewById(R.id.id);
        id.setText("1/"+data);




        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(j==0){
                    myStack_question.pop();
                    myStack_description.pop();
                    j++;

                }
                else{

                }



                if(myStack_question.isEmpty() && myStack_description.isEmpty()){
                    Toast.makeText(GamePartSecondPage.this, "See on esimene küsimus",
                            Toast.LENGTH_LONG).show();
                    myStack_question.push(questions[first_question]);
                    myStack_description.push(description[first_question]);
                    j--;

                }
                else{
                    String str1 = (String) myStack_question.pop();
                    String str2 = (String) myStack_description.pop();

                    txt.setText(str1);
                    txt.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_right));
                    txt1.setText(str2);
                    txt1.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_left));
                    que_question++;
                    child = false;
                    parent = false;
                    parent_score--;
                    child_score--;
                    Drawable newImage3 = getResources().getDrawable(R.drawable.white_cross);
                    Drawable newImage4 = getResources().getDrawable(R.drawable.white_tick);
                    parent_no.setBackgroundDrawable(newImage3);
                    child_no.setBackgroundDrawable(newImage3);
                    parent_yes.setBackgroundDrawable(newImage4);
                    child_yes.setBackgroundDrawable(newImage4);

                    image_change_back(progress_image);
                    progress_image--;

                }



            }
        });



        child_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                child_ans = 0;
                child_yes.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_tick));
                child_no.setBackgroundDrawable(getResources().getDrawable(R.drawable.green_cross));
                child = true;
                if(parent==true && child==true){
                    if (parents_ans==1 && child_ans==1){
                        parent_score++;
                        child_score++;
                    }
                    else if(parents_ans==1 && child_ans ==0){
                        parent_score++;
                    }
                    else if(parents_ans==0 &&child_ans==1){
                        child_score++;
                    }
                    else{
                        //nothing
                    }



                    if (que_question > 1) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mark = RandomNumber();
                                txt.setText(questions[mark]);
                                txt.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_right));
                                txt1.setText(description[mark]);
                                txt1.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_left));
                                myStack_question.push(questions[mark]);
                                myStack_description.push(description[mark]);
                                que_question--;
                                child = false;
                                parent = false;
                                Drawable newImage3 = getResources().getDrawable(R.drawable.white_cross);
                                Drawable newImage4 = getResources().getDrawable(R.drawable.white_tick);
                                parent_no.setBackgroundDrawable(newImage3);
                                child_no.setBackgroundDrawable(newImage3);
                                parent_yes.setBackgroundDrawable(newImage4);
                                child_yes.setBackgroundDrawable(newImage4);

                               image_change(progress_image);
                                progress_image++;

                            }
                        }, 800);


                    }

                    else{

                        if(parent_score>child_score){

                            winner = "Seekord võitis Suur Karu…!";
                        }
                        else if (parent_score==child_score) {
                            winner = "Nii Väike kui Suur Karu on olnud tublid! (Viik)";

                        }
                        else {

                            winner = "Seekord võitis Väike Karu…!";
                        }

                        Intent i = new Intent(GamePartSecondPage.this, GamePartThirdPage.class);
                        i.putExtra("key_name",winner);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        //viewPager.setCurrentItem(2);
                    }

                } else {

                }


            }
        });

        child_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                child_ans = 1;
                Drawable newImage = getResources().getDrawable(R.drawable.white_cross);
                Drawable newImage1 = getResources().getDrawable(R.drawable.green_tick);
                child_yes.setBackgroundDrawable(newImage1);
                child_no.setBackgroundDrawable(newImage);
                child = true;

                if (parent == true && child == true) {
                    if (parents_ans == 1 && child_ans == 1) {
                        parent_score++;
                        child_score++;
                    } else if (parents_ans == 1 && child_ans == 0) {
                        parent_score++;
                    } else if (parents_ans == 0 && child_ans == 1) {
                        child_score++;
                    } else {
                        //nothing
                    }


                    if (que_question > 1) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mark = RandomNumber();
                                txt.setText(questions[mark]);
                                txt.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_right));
                                txt1.setText(description[mark]);
                                txt1.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_left));
                                myStack_question.push(questions[mark]);
                                myStack_description.push(description[mark]);
                                que_question--;
                                child = false;
                                parent = false;
                                Drawable newImage3 = getResources().getDrawable(R.drawable.white_cross);
                                Drawable newImage4 = getResources().getDrawable(R.drawable.white_tick);
                                parent_no.setBackgroundDrawable(newImage3);
                                child_no.setBackgroundDrawable(newImage3);
                                parent_yes.setBackgroundDrawable(newImage4);
                                child_yes.setBackgroundDrawable(newImage4);
                                image_change(progress_image);
                                progress_image++;

                            }
                        }, 800);


                    } else {

                        if(parent_score>child_score){

                            winner = "Seekord võitis Suur Karu…!";
                        }
                        else if (parent_score==child_score) {
                            winner = "Nii Väike kui Suur Karu on olnud tublid! (Viik)";

                        }
                        else {

                            winner = "Seekord võitis Väike Karu…!";
                        }

                        Intent i = new Intent(GamePartSecondPage.this, GamePartThirdPage.class);
                        i.putExtra("key_name", winner);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        //viewPager.setCurrentItem(2);
                    }

                }

            }
        });

        parent_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parents_ans = 0;
                Drawable newImage = getResources().getDrawable(R.drawable.green_cross);
                Drawable newImage1 = getResources().getDrawable(R.drawable.white_tick);
                parent_yes.setBackgroundDrawable(newImage1);
                parent_no.setBackgroundDrawable(newImage);
                parent = true;

                if (parent == true && child == true) {
                    if (parents_ans == 1 && child_ans == 1) {
                        parent_score++;
                        child_score++;
                    } else if (parents_ans == 1 && child_ans == 0) {
                        parent_score++;
                    } else if (parents_ans == 0 && child_ans == 1) {
                        child_score++;
                    } else {
                        //nothing
                    }


                    if (que_question > 1) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mark = RandomNumber();
                                txt.setText(questions[mark]);
                                txt.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_right));
                                txt1.setText(description[mark]);
                                txt1.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_left));
                                myStack_question.push(questions[mark]);
                                myStack_description.push(description[mark]);
                                que_question--;
                                child = false;
                                parent = false;
                                Drawable newImage3 = getResources().getDrawable(R.drawable.white_cross);
                                Drawable newImage4 = getResources().getDrawable(R.drawable.white_tick);
                                parent_no.setBackgroundDrawable(newImage3);
                                child_no.setBackgroundDrawable(newImage3);
                                parent_yes.setBackgroundDrawable(newImage4);
                                child_yes.setBackgroundDrawable(newImage4);

                                image_change(progress_image);
                                progress_image++;

                            }
                        }, 800);


                    } else {

                        if(parent_score>child_score){

                            winner = "Seekord võitis Suur Karu…!";
                        }
                        else if (parent_score==child_score) {
                            winner = "Nii Väike kui Suur Karu on olnud tublid! (Viik)";

                        }
                        else {

                            winner = "Seekord võitis Väike Karu…!";
                        }

                        Intent i = new Intent(GamePartSecondPage.this, GamePartThirdPage.class);
                        i.putExtra("key_name", winner);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        //viewPager.setCurrentItem(2);
                    }

                }

            }
        });

        parent_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parents_ans = 1;
                Drawable newImage = getResources().getDrawable(R.drawable.white_cross);
                Drawable newImage1 = getResources().getDrawable(R.drawable.green_tick);
                parent_yes.setBackgroundDrawable(newImage1);
                parent_no.setBackgroundDrawable(newImage);
                parent = true;
                if (parent == true && child == true) {
                    if (parents_ans == 1 && child_ans == 1) {
                        parent_score++;
                        child_score++;
                    } else if (parents_ans == 1 && child_ans == 0) {
                        parent_score++;
                    } else if (parents_ans == 0 && child_ans == 1) {
                        child_score++;
                    } else {
                        //nothing
                    }


                    if (que_question > 1) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mark = RandomNumber();
                                txt.setText(questions[mark]);
                                txt.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_right));
                                txt1.setText(description[mark]);
                                txt1.startAnimation(AnimationUtils.loadAnimation(GamePartSecondPage.this, R.anim.slide_slow_left));
                                myStack_question.push(questions[mark]);
                                myStack_description.push(description[mark]);
                                que_question--;
                                child = false;
                                parent = false;
                                Drawable newImage3 = getResources().getDrawable(R.drawable.white_cross);
                                Drawable newImage4 = getResources().getDrawable(R.drawable.white_tick);
                                parent_no.setBackgroundDrawable(newImage3);
                                child_no.setBackgroundDrawable(newImage3);
                                parent_yes.setBackgroundDrawable(newImage4);
                                child_yes.setBackgroundDrawable(newImage4);


                                image_change(progress_image);
                                progress_image++;

                            }
                        }, 800);


                    } else {

                        if(parent_score>child_score){

                            winner = "Seekord võitis Suur Karu…!";
                        }
                        else if (parent_score==child_score) {
                            winner = "Nii Väike kui Suur Karu on olnud tublid! (Viik)";

                        }
                        else {

                            winner = "Seekord võitis Väike Karu…!";
                        }


                        Intent i = new Intent(GamePartSecondPage.this, GamePartThirdPage.class);
                        i.putExtra("key_name", winner);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();
                        //viewPager.setCurrentItem(2);
                    }

                }


            }
        });



    }

    public void image_change(int i){
        i=i+1;
        if(i== 1) {
            id.setText("1/"+data);
        } else if (i == 2) {
            id.setText("2/"+data);
        }
        else if(i==3){
            id.setText("3/" + data);
        }
        else if(i==4){
            id.setText("4/" + data);
        }
        else if(i==5){
            id.setText("5/" + data);
        }
        else if(i==6){
            id.setText("6/" + data);
        }
        else if(i==7){
            id.setText("7/" + data);
        }
        else if(i==8){
            id.setText("8/" + data);
        }
        else if(i==9){
            id.setText("9/" + data);
        }
        else if(i==10){
            id.setText("10/" + data);
        }
        else if(i==11){
            id.setText("11/" + data);
        }
        else if(i==12){
            id.setText("12/" + data);
        }
        else if(i==13){
            id.setText("13/" + data);
        }
        else if(i==14){
            id.setText("14/" + data);
        }
        else if(i==15){
            id.setText("15/" + data);
        }
        else if(i==16){
            id.setText("16/" + data);
        }
        else if(i==17){
            id.setText("17/" + data);
        }
        else if(i==18){
            id.setText("18/" + data);
        }
        else if(i==19){
            id.setText("19/" + data);
        }
        else{
            id.setText("20/" + data);
        }


    }


    public void image_change_back(int i) {

        i = i-1;
        if(i== 1) {
            id.setText("1/"+data);
        } else if (i == 2) {
            id.setText("2/"+data);
        }
        else if(i==3){
            id.setText("3/" + data);
        }
        else if(i==4){
            id.setText("4/" + data);
        }
        else if(i==5){
            id.setText("5/" + data);
        }
        else if(i==6){
            id.setText("6/" + data);
        }
        else if(i==7){
            id.setText("7/" + data);
        }
        else if(i==8){
            id.setText("8/" + data);
        }
        else if(i==9){
            id.setText("9/" + data);
        }
        else if(i==10){
            id.setText("10/" + data);
        }
        else if(i==11){
            id.setText("11/" + data);
        }
        else if(i==12){
            id.setText("12/" + data);
        }
        else if(i==13){
            id.setText("13/" + data);
        }
        else if(i==14){
            id.setText("14/" + data);
        }
        else if(i==15){
            id.setText("15/" + data);
        }
        else if(i==16){
            id.setText("16/" + data);
        }
        else if(i==17){
            id.setText("17/" + data);
        }
        else if(i==18){
            id.setText("18/" + data);
        }
        else if(i==19){
            id.setText("19/" + data);
        }
        else{
            id.setText("20/"+data);
        }

    }

    public static int RandomNumber(){
        int random = 0;
        Random r = new Random();
        random = r.nextInt(19-0)+0;

        return random;
    }

}
