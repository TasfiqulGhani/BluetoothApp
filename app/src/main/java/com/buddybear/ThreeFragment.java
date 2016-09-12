package com.buddybear;

/**
 * Created by U on 1/29/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by U on 1/29/2016.
 */


public class ThreeFragment extends Fragment {

    public ListView list;
    String m;
    int pos;
    public	double sumOfCr=0;
    double sumOfGr=0;
    String nl="\n\n";
    double cgpa=0.0;
    String st;
    public  String s,kk,res="0";

    SQLiteDatabase database;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] title;
    String[] description;
    int[] image;
    Weeks w;
    ArrayList<Weeks> arraylist = new ArrayList<Weeks>();
    public ThreeFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_three, container, false);


        return rootView;
    }

}