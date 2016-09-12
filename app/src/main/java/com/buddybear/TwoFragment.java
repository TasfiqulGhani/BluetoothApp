package com.buddybear;

/**
 * Created by U on 1/29/2016.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by U on 1/29/2016.
 */


public class TwoFragment extends Fragment {



    // YouTubeのビデオID


    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        firstThread();
        secondThread();
        thirdThread();
        fourthThread();
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/gillsans.ttf");
        TextView txt1 = (TextView) rootView.findViewById(R.id.txt1);
        TextView txt2 = (TextView) rootView.findViewById(R.id.txt2);
        TextView txt3 = (TextView) rootView.findViewById(R.id.txt3);
        TextView txt4 = (TextView) rootView.findViewById(R.id.txt4);

        txt1.setTypeface(font);
        txt2.setTypeface(font);
        txt3.setTypeface(font);
        txt4.setTypeface(font);


        return rootView;
    }
    public void firstVideo(){

        YouTubePlayerSupportFragment youTubePlayerFragmenttwo = YouTubePlayerSupportFragment.newInstance();

        // レイアウトにYouTubeフラグメントを追加
        FragmentTransaction transactiontwo = getChildFragmentManager().beginTransaction();
        transactiontwo.add(R.id.youtube_layout, youTubePlayerFragmenttwo).commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        youTubePlayerFragmenttwo.initialize("AIzaSyCN2WHw0aeyaDu4ipdgp6OJkk22WsIX0Ba", new YouTubePlayer.OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider1, YouTubePlayer player1, boolean wasRestored1) {
                if (!wasRestored1) {
                    player1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player1.cueVideo("5GGW0ZmyhDk");


                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider1, YouTubeInitializationResult error1) {
                // YouTube error
                String errorMessage = error1.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }
        });

    }

    public void secondVideo(){

        YouTubePlayerSupportFragment youTubePlayerFragmenttwo = YouTubePlayerSupportFragment.newInstance();

        // レイアウトにYouTubeフラグメントを追加
        FragmentTransaction transactiontwo = getChildFragmentManager().beginTransaction();
        transactiontwo.add(R.id.youtube_layout2, youTubePlayerFragmenttwo).commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        youTubePlayerFragmenttwo.initialize("AIzaSyCN2WHw0aeyaDu4ipdgp6OJkk22WsIX0Bf", new YouTubePlayer.OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider1, YouTubePlayer player1, boolean wasRestored1) {
                if (!wasRestored1) {
                    player1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player1.cueVideo("hv-1d1db_9U");


                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider1, YouTubeInitializationResult error1) {
                // YouTube error
                String errorMessage = error1.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }
        });

    }
    public void thirdVideo(){

        YouTubePlayerSupportFragment youTubePlayerFragmenttwo = YouTubePlayerSupportFragment.newInstance();

        // レイアウトにYouTubeフラグメントを追加
        FragmentTransaction transactiontwo = getChildFragmentManager().beginTransaction();
        transactiontwo.add(R.id.youtube_layout3, youTubePlayerFragmenttwo).commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        youTubePlayerFragmenttwo.initialize("AIzaSyCN2WHw0aeyaDu4ipdgp6OJkk22WsIX0Bz", new YouTubePlayer.OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider1, YouTubePlayer player1, boolean wasRestored1) {
                if (!wasRestored1) {
                    player1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player1.cueVideo("-CwlAWyAOQg");

                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider1, YouTubeInitializationResult error1) {
                // YouTube error
                String errorMessage = error1.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }
        });

    }

    public void fourthVideo(){

        YouTubePlayerSupportFragment youTubePlayerFragmenttwo = YouTubePlayerSupportFragment.newInstance();

        // レイアウトにYouTubeフラグメントを追加
        FragmentTransaction transactiontwo = getChildFragmentManager().beginTransaction();
        transactiontwo.add(R.id.youtube_layout4, youTubePlayerFragmenttwo).commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        youTubePlayerFragmenttwo.initialize("AIzaSyCN2WHw0aeyaDu4ipdgp6OJkk22WsIX0Bn", new YouTubePlayer.OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider1, YouTubePlayer player1, boolean wasRestored1) {
                if (!wasRestored1) {
                    player1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player1.cueVideo("1CdwOe-5OaA");


                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider1, YouTubeInitializationResult error1) {
                // YouTube error
                String errorMessage = error1.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }
        });

    }
    protected void firstThread() {
        Thread t = new Thread() {
            public void run() {
                firstVideo();

            }
        };

        t.start();
    }



    protected void secondThread() {
        Thread t = new Thread() {
            public void run() {
                secondVideo();

            }
        };

        t.start();
    }



    protected void thirdThread() {
        Thread t = new Thread() {
            public void run() {
                thirdVideo();

            }
        };

        t.start();
    }




    protected void fourthThread() {
        Thread t = new Thread() {
            public void run() {
                fourthVideo();

            }
        };

        t.start();
    }



}


