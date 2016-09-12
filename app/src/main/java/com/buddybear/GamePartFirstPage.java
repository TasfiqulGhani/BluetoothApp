package com.buddybear;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;


public class GamePartFirstPage extends AppCompatActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    ImageButton setting_btn;
    String data = "";
    int select = 1;
    Button editText;
    Button plus, minus;
    int flag = 0;
    TextView txt ;
    BluetoothSPP bt;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_part_first_page);
        bt = new BluetoothSPP(GamePartFirstPage.this);
          tv= (TextView) findViewById(R.id.tv);
        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(GamePartFirstPage.this, setting_page.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(GamePartFirstPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin2 = (RelativeLayout) findViewById(R.id.linBottomTwo);
        lin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(GamePartFirstPage.this, TodoFirstPage.class);

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
                Intent i2 = new Intent(GamePartFirstPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        BottomTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(GamePartFirstPage.this, TodoFirstPage.class);

                startActivity(k);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            public void onDeviceConnected(String name, String address) {
                tv.setText("Device Connected .");
            }

            public void onDeviceDisconnected() {
                tv.setText("Device Disconnected .");
            }

            public void onDeviceConnectionFailed() {
                tv.setText("Connection failed .");
            }

            public void onServiceStateChanged(int state) {
                if(state == BluetoothState.STATE_CONNECTED) {
                    tv.setText("Connected .");
                }
                else if(state == BluetoothState.STATE_CONNECTING)

                {
                      tv.setText("Connecting .");

                } else if(state == BluetoothState.STATE_LISTEN) {  tv.setText("Waiting for connection.");
                }else if(state == BluetoothState.STATE_NONE) { tv.setText("Not connected .");

                }
                }


        });




    }



    public void connect(View v){


        try{

            if(!bt.isBluetoothAvailable() ) {
                tv.setText("Turn one bluetooth.");


            } else {
                bt.startService(BluetoothState.DEVICE_OTHER);
                Intent intent = new Intent(getApplicationContext(), DeviceList.class);
                startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
            }
            bt.setupService();
            bt.startService(true);
        }
catch (Exception e){
    tv.setText("Turn on bluetooth .");
}


    }


    public void dconnect(View v){
        bt.stopService();
    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if(resultCode == Activity.RESULT_OK)
                bt.connect(data);
        } else if(requestCode == BluetoothState.REQUEST_ENABLE_BT) {
            if(resultCode == Activity.RESULT_OK) {
                bt.setupService();
                bt.startService(BluetoothState.DEVICE_ANDROID);
                bt.send("Message", true);
                tv.setText("Sending data .");
            } else {
                // Do something if user doesn't choose any device (Pressed back)
            }
        }
    }


}
