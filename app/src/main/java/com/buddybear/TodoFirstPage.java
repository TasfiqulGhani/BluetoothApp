package com.buddybear;

import android.app.ExpandableListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TodoFirstPage extends  ExpandableListActivity {
    Button  BottomOne,BottomTwo,BottomThree;
    int pos;
    ImageButton setting_btn;
    //Initialize variables
    TextView Tcounter;
    List<String> firstchildren = new ArrayList<String>();
    List<String> firstparent = new ArrayList<String>();
    String checker;
    private static final String STR_CHECKED = " has Checked!";
    private static final String STR_UNCHECKED = " has unChecked!";
    private int ParentClickStatus=-1;
    private int ChildClickStatus=-1;
    private ArrayList<Parent> parents;
    SQLiteDatabase database;
    String sql;
    Cursor c;
    int count =0;
    int limit=5;
    TextView tcounter;

    Typeface font;

    List<String> secchildren = new ArrayList<String>();
    List<String> secparent = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_first_page);

       font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");




        setting_btn = (ImageButton) findViewById(R.id.settings_button);


        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TodoFirstPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });






        SQLiteDatabase  database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        String sqlz = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sqlz);
        sqlz = "SELECT * from todoSecondv;";
        Cursor cz = database.rawQuery(sqlz, null);



        while (cz.moveToNext()) {


            checker = cz.getString(cz.getColumnIndex("Todo"));




        }
        if (checker != null && !checker.isEmpty()) {
            Intent i=new Intent(this,TodoSecondPage.class);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();

        }





        tcounter=(TextView)findViewById(R.id.count);


        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoFirstPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin3 = (RelativeLayout) findViewById(R.id.linBottomThree);
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoFirstPage.this, GamePartFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        BottomOne=(Button)findViewById(R.id.bottomone);
        BottomTwo=(Button)findViewById(R.id.bottomtwo);
        BottomThree=(Button)findViewById(R.id.bottomthree);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(TodoFirstPage.this);
                LayoutInflater inflater = TodoFirstPage.this.getLayoutInflater();
                final View dialogView = inflater.inflate(R.layout.customdialog, null);
                dialogBuilder.setView(dialogView);

                final EditText h = (EditText) dialogView.findViewById(R.id.head);
                final EditText d = (EditText) dialogView.findViewById(R.id.des);

                dialogBuilder.setTitle("Add Excercise ");

                dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {


                        FirstPageDB(h.getText().toString(), d.getText().toString());
                        Intent intent = getIntent();
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        finish();

                    }
                });
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //pass
                    }
                });
                AlertDialog b = dialogBuilder.create();
                b.show();


            }
        });

        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2=new Intent(TodoFirstPage.this,NewsFeedFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        BottomThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k=new Intent(TodoFirstPage.this,GamePartFirstPage.class);
                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        tcounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TodoFirstPage.this);
                alertDialog.setTitle("Free To Walk");
                alertDialog.setMessage("How many excercise you want to choose");

                final EditText input = new EditText(TodoFirstPage.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);
                alertDialog.setIcon(R.drawable.big_bear_converted);

                alertDialog.setPositiveButton("Done",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                limit= Integer.parseInt(input.getText().toString());



                                if(input.getText().toString().length()==1){
                                    tcounter.setText(" "+input.getText().toString());
                                }
                                else{
                                    tcounter.setText(""+input.getText().toString());
                                }

                                if(limit>parents.size()){
                                    Toast.makeText(TodoFirstPage.this, "Done 1-" + parents.size(), Toast.LENGTH_LONG).show();
                                    limit=5;
                                    tcounter.setText(" "+limit);
                                }



                            }
                        });

                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todofirst (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sql);
        String	 sqlx = "SELECT * from todofirst;";
        Cursor c = database.rawQuery(sqlx, null);



        while (c.moveToNext()) {


            String h = c.getString(c.getColumnIndex("Todo"));

            String d = c.getString(c.getColumnIndex("des"));
            firstparent.add(h);
            firstchildren.add( d);


        }


        firstparent.add("Side Plank with Bent Knee");
        firstchildren.add("Great way to add in hips work without the need for any equipment other than your own body weight.");

        firstparent.add("Front Plank");
        firstchildren.add("This is harder than it looks!  Your back and abs will love you.");

        firstparent.add("Push-up with Single-leg Raise");
        firstchildren.add( "A great progression from a regular Push-Up but remember to keep proper form.");

        firstparent.add("Bent-Knee Sit-up / Crunches");
        firstchildren.add("Most people don’t know how to perform a proper sit-up/crunch – that is until now.  Core Power!");

        firstparent.add("Downward-facing Dog");
        firstchildren.add("Slow and controlled movement very important – wonderful calf stretch.");

        firstparent.add("Bent Knee Push-up");
        firstchildren.add("A great starting option if you struggle with the correct form using a full Push-Up.");

        firstparent.add("Contralateral Limb Raises");
        firstchildren.add("Don’t let the name scare you – this is great for toning those troubling upper body areas.");

        firstparent.add("Push-Up - American Council on Exercise");
        firstchildren.add("The Push-up is an oldie but goodie.  You can modify intensity by changing hand placement.");

        firstparent.add("Supermans");
        firstchildren.add("Who doesn't want to think they have super powers?  Great stretch as well when you picture trying to touch the opposing walls with your fingers and toes.\n");



        Resources res = this.getResources();


        // Set ExpandableListView values



        getExpandableListView().setGroupIndicator(null);


        getExpandableListView().setDivider(null);
        registerForContextMenu(getExpandableListView());

        //Creating static data in arraylist
        final ArrayList<Parent> dummyList = buildDummyData();

        // Adding ArrayList data to ExpandableListView values
        loadHosts(dummyList);
    }
    private ArrayList<Parent> buildDummyData()
    {
        // Creating ArrayList of type parent class to store parent class objects
        final ArrayList<Parent> list = new ArrayList<Parent>();



        for (int i = 0; i < firstparent.size(); i++)
        {
            final Parent parent = new Parent();

            for (int x = 0; x < firstparent.size(); x++) {
                parent.setName("" + firstparent.get(i));
                parent.setText1("" + firstparent.get(i));
                parent.setText2("");
                parent.setChildren(new ArrayList<Child>());

                // Create Child class object
                final Child child = new Child();

                child.setText1(" " + firstchildren.get(i));

                //Add Child class object to parent class object
                parent.getChildren().add(child);
            }
            list.add(parent);
        }

        return list;
    }



    private void loadHosts(final ArrayList<Parent> newParents)
    {
        if (newParents == null)
            return;

        parents = newParents;

        // Check for ExpandableListAdapter object
        if (this.getExpandableListAdapter() == null)
        {
            //Create ExpandableListAdapter Object
            final MyExpandableListAdapter mAdapter = new MyExpandableListAdapter();

            // Set Adapter to ExpandableList Adapter
            this.setListAdapter(mAdapter);
        }
        else
        {
            // Refresh ExpandableListView data
            ((MyExpandableListAdapter)getExpandableListAdapter()).notifyDataSetChanged();
        }
    }

    /**
     * A Custom adapter to create Parent view (Used grouprow.xml) and Child View((Used childrow.xml).
     */
    private class MyExpandableListAdapter extends BaseExpandableListAdapter {


        private LayoutInflater inflater;

        public MyExpandableListAdapter() {
            // Create Layout Inflator
            inflater = LayoutInflater.from(TodoFirstPage.this);
        }


        // This Function used to inflate parent rows view

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parentView) {
            final Parent parent = parents.get(groupPosition);

            // Inflate grouprow.xml file for parent rows
            convertView = inflater.inflate(R.layout.grouprow, parentView, false);

            // Get grouprow.xml file elements and set values
          TextView tv = ((TextView) convertView.findViewById(R.id.boro));
            tv.setText(parent.getText1());
            tv.setTypeface(font);
            ((TextView) convertView.findViewById(R.id.text)).setText(parent.getText2());


            // Get grouprow.xml file checkbox elements
            CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            checkbox.setChecked(parent.isChecked());
            if (parent.isChecked()) {
                checkbox.setBackgroundResource(R.drawable.listchecked);
            } else {
                checkbox.setBackgroundResource(R.drawable.listuncheck);
            }
            // Set CheckUpdateListener for CheckBox (see below CheckUpdateListener class)
            checkbox.setOnCheckedChangeListener(new CheckUpdateListener(parent));

            return convertView;
        }


        // This Function used to inflate child rows view
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parentView) {
            final Parent parent = parents.get(groupPosition);
            final Child child = parent.getChildren().get(childPosition);

            // Inflate childrow.xml file for child rows
            convertView = inflater.inflate(R.layout.childrow, parentView, false);

            // Get childrow.xml file elements and set values
            TextView tv1 = ((TextView) convertView.findViewById(R.id.choto));
            tv1.setText(child.getText1());
            tv1.setTypeface(font);

            return convertView;
        }


        @Override
        public Object getChild(int groupPosition, int childPosition) {
            //Log.i("Childs", groupPosition+"=  getChild =="+childPosition);
            return parents.get(groupPosition).getChildren().get(childPosition);
        }

        //Call when child row clicked
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            /****** When Child row clicked then this function call *******/

            //Log.i("Noise", "parent == "+groupPosition+"=  child : =="+childPosition);
            if (ChildClickStatus != childPosition) {
                ChildClickStatus = childPosition;


            }

            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            int size = 0;
            if (parents.get(groupPosition).getChildren() != null)
                size = parents.get(groupPosition).getChildren().size();
            return size;
        }


        @Override
        public Object getGroup(int groupPosition) {
            Log.i("Parent", groupPosition + "=  getGroup ");

            return parents.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return parents.size();
        }

        //Call when parent row clicked
        @Override
        public long getGroupId(int groupPosition) {
            Log.i("Parent", groupPosition + "=  getGroupId " + ParentClickStatus);

            if (groupPosition == 2 && ParentClickStatus != groupPosition) {


            }

            ParentClickStatus = groupPosition;
            if (ParentClickStatus == 0)
                ParentClickStatus = -1;

            return groupPosition;
        }

        @Override
        public void notifyDataSetChanged() {
            // Refresh List rows
            super.notifyDataSetChanged();
        }

        @Override
        public boolean isEmpty() {
            return ((parents == null) || parents.isEmpty());
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }


        /*******************
         * Checkbox Checked Change Listener
         ********************/

        private final class CheckUpdateListener implements CompoundButton.OnCheckedChangeListener {
            private final Parent parent;


            private CheckUpdateListener(Parent parent) {
                this.parent = parent;

            }

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("onCheckedChanged", "isChecked: " + isChecked);
                parent.setChecked(isChecked);

                ((MyExpandableListAdapter) getExpandableListAdapter()).notifyDataSetChanged();

                final Boolean checked = parent.isChecked();


                for (int i = 0; i < parents.size(); i++) {
                    if (parent.getName().equalsIgnoreCase(firstparent.get(i))) {
                        pos = i;
                    }

                }

                if (checked) {

                    createDatabase(firstparent.get(pos), firstchildren.get(pos));
                    Log.e("Name", "" + parent.getChildren().toString());
                    count++;
                    if (count == limit) {

                        Calendar c = Calendar.getInstance();
                        int hour = c.get(Calendar.HOUR_OF_DAY);

                        int seconds = c.get(Calendar.SECOND);
                        int minutes = c.get(Calendar.MINUTE);


                        TimeDb(""+hour,""+minutes,""+seconds );

                        Intent i = new Intent(TodoFirstPage.this, TodoSecondPage.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                        finish();

                    }
                } else {


                    count--;
                    database = openOrCreateDatabase("Todo", MODE_PRIVATE, null);

                    sql = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
                    database.execSQL(sql);
                    String sqlx = "SELECT * from todoSecondv;";
                    Cursor cw = database.rawQuery(sqlx, null);


                    while (cw.moveToNext()) {


                        String h = cw.getString(cw.getColumnIndex("Todo"));

                        String d = cw.getString(cw.getColumnIndex("des"));
                        secparent.add(h);
                        secchildren.add(d);


                    }


                    database.execSQL("DROP TABLE IF EXISTS todoSecondv");
                    for (int i = 0; i < secchildren.size(); i++) {

                        if (!secparent.get(i).equalsIgnoreCase(firstparent.get(pos))) {
                            createDatabase(secparent.get(i), secchildren.get(i));
                        }


                    }


                }


            }

            void createDatabase(String todo, String des) {


                database = openOrCreateDatabase("Todo", MODE_PRIVATE, null);

                sql = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
                c = database.rawQuery(sql, null);

                database.execSQL(sql);


                String insertSql = "INSERT INTO todoSecondv VALUES('" + todo + "','" + des + "' );";
                database.execSQL(insertSql);


                database.close();


            }


        }
    }

    void FirstPageDB(String todo, String des ){


        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todofirst (Todo VARCHAR ,des VARCHAR  );";
        c = database.rawQuery(sql, null);

        database.execSQL(sql);


        String insertSql = "INSERT INTO todofirst VALUES('"+todo+"','"+des+"' );";
        database.execSQL(insertSql);


        database.close();



    }


    void TimeDb(String Hour, String Min,String Sec ){


        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS TimeDb (Hour VARCHAR ,Min VARCHAR  ,Sec VARCHAR  );";
        c = database.rawQuery(sql, null);

        database.execSQL(sql);


        String insertSql = "INSERT INTO TimeDb VALUES('"+Hour+"','"+Min+"','"+Sec+"' );";
        database.execSQL(insertSql);


        database.close();



    }
}