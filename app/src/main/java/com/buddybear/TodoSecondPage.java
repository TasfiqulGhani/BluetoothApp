package com.buddybear;

import android.app.AlarmManager;
import android.app.ExpandableListActivity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TodoSecondPage extends ExpandableListActivity {
    public int seconds = 60;
    public int minutes = 10;
    public int hour=12;

    Button  BottomOne,BottomTwo,BottomThree,lopeta;
    int checkedtodo=0;
    int date;
    ImageButton setting_btn;
    CheckBox checkbox;
    List<Integer> checkList = new ArrayList<Integer>();
    List<String> secchildren = new ArrayList<String>();
    List<String> secparent = new ArrayList<String>();
    List<String> secchildrenprog = new ArrayList<String>();
    List<String> secparentprog = new ArrayList<String>();
    int pos;
    //main percent
    int percent;
    int counter=0;
    String checker;
    TextView tcounter;
    TextView days ;
    private static final String STR_CHECKED = " has Checked!";
    private static final String STR_UNCHECKED = " has unChecked!";
    private int ParentClickStatus=-1;
    private int ChildClickStatus=-1;
    private ArrayList<Parent> parents;
    SQLiteDatabase database;
    String sql;
    int temp;
    Cursor c;
    int dayCount=0;
    ProgressBar mProgress;
    Typeface font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_second_page);

        Calendar cx = Calendar.getInstance();
        int currentDate = cx.get(Calendar.DATE);
        int currentMonth = cx.get(Calendar.MONTH);
        int currentY = cx.get(Calendar.YEAR);


        Intent intent = new Intent(TodoSecondPage.this, TodoAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 20, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

        setAlarm(currentDate + 3, currentMonth + 1, currentY, 20);



        setting_btn = (ImageButton) findViewById(R.id.settings_button);

        font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(TodoSecondPage.this, setting_page.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });

        RelativeLayout lin1 = (RelativeLayout) findViewById(R.id.linBottomOne);
        lin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoSecondPage.this, NewsFeedFirstPage.class);

                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        RelativeLayout lin3 = (RelativeLayout) findViewById(R.id.linBottomThree);
        lin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(TodoSecondPage.this, GamePartFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();
            }
        });

        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todotime (Time VARCHAR);";
        database.execSQL(sql);
        String	 dd = "SELECT * from todotime;";
        Cursor cd = database.rawQuery(dd, null);



        while (cd.moveToNext()) {


            checker = cd.getString(cd.getColumnIndex("Time"));

        }

        if (checker != null && !checker.isEmpty()) {
            date=Integer.parseInt(checker);

        }else {
            Calendar c = Calendar.getInstance();
            int datee = c.get(Calendar.DATE);
            date=datee;
            Tododate("" + datee);

        }





        Resources lin = getResources();
        Drawable drawable = lin.getDrawable(R.drawable.linearprogressbar);
        mProgress = (ProgressBar) findViewById(R.id.progressbar1);

        // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);


        Resources cir = getResources();
        Drawable drawablea = cir.getDrawable(R.drawable.circleprogress);
        ProgressBar mProgressax = (ProgressBar) findViewById(R.id.circularProgressbar);
        // Main Progress
        // Secondary Progress
        mProgressax.setMax(100); // Maximum Progress
        mProgressax.setProgressDrawable(drawablea);


        lopeta = (Button) findViewById(R.id.lopeta);
        BottomOne = (Button) findViewById(R.id.bottomone);
        BottomTwo = (Button) findViewById(R.id.bottomtwo);
        BottomThree = (Button) findViewById(R.id.bottomthree);
        tcounter= (TextView) findViewById(R.id.tcount);
        days = (TextView) findViewById(R.id.timer);

        Calendar cx1 = Calendar.getInstance();
        int today = cx1.get(Calendar.DATE);

        if(today>date){
            dayCount = 6-(today-date);
            if(dayCount<0){
                dayCount=0;
            }

        }else if (today<date){

            today=today+30;
            dayCount = 6-(today-date);
            if(dayCount<0){
                dayCount=0;
            }



        }else if(today==date){
            dayCount=6;
        }else{
            dayCount=6;
        }
        Log.e("dayCount",""+dayCount);
        Log.e("date",""+date);
        Log.e("today",""+today);
        startTimer();

        BottomOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i2 = new Intent(TodoSecondPage.this, NewsFeedFirstPage.class);
                startActivity(i2);
                overridePendingTransition(0, 0);
                finish();

            }
        });

        BottomThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent k = new Intent(TodoSecondPage.this, GamePartFirstPage.class);
                startActivity(k);
                overridePendingTransition(0, 0);
                finish();
            }
        });


        lopeta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                getApplicationContext().deleteDatabase("Todo");



                Intent i=new Intent(TodoSecondPage.this,TodoFirstPage.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                finish();


            }
        });
        Resources res = this.getResources();


        // Set ExpandableListView values


        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todoSecondv (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sql);
        String	 sqlx = "SELECT * from todoSecondv;";
        Cursor cw = database.rawQuery(sqlx, null);



        while (cw.moveToNext()) {


            String h = cw.getString(cw.getColumnIndex("Todo"));

            String d = cw.getString(cw.getColumnIndex("des"));
            secparent.add(h);
            secchildren.add( d);
            counter++;

        }
        if(counter==1){
            counter=0;
        }

        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        String sqlq  = "CREATE TABLE IF NOT EXISTS todoprog (Todo VARCHAR ,des VARCHAR  );";
        database.execSQL(sqlq);
        String	 sqlxq = "SELECT * from todoprog;";
        Cursor cq = database.rawQuery(sqlxq, null);



        while (cq.moveToNext()) {


            String hs = cq.getString(cq.getColumnIndex("Todo"));

            String ds = cq.getString(cq.getColumnIndex("des"));
            secchildrenprog.add(ds);
            secparentprog.add(hs);
            checkedtodo++;

        }

        if(counter==0){
            counter=1;
        }
        temp=100/counter;
        int rem = 100%counter;
        temp=temp+rem;


        for(int i=0;i<checkedtodo;i++){
            percent=temp+percent;

        }
        //ekhan theke jabe 100%
        if(percent>=100){

            getApplicationContext().deleteDatabase("Todo");


            Intent x=new Intent(TodoSecondPage.this,TodoThirdPage.class);
            x.putExtra("percent",percent+"");
            startActivity(x);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();



        }

        mProgress.setProgress(percent);
        tcounter.setText(percent+"%");

        if(dayCount==6){
            mProgressax.setProgress(100);
        }else if(dayCount==5){
            mProgressax.setProgress(16+16+16+16+16+16);
        }else if(dayCount==4){
            mProgressax.setProgress(16+16+16+16+16);
        }else if(dayCount==3){
            mProgressax.setProgress(16+16+16+16);
        }else if(dayCount==2){
            mProgressax.setProgress(16+16+16);
        }else if(dayCount==1){
            mProgressax.setProgress(16+16);
        }else if(dayCount==0){
            mProgressax.setProgress(16);
        }

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



        for (int i = 0; i < secparent.size(); i++)
        {
            final Parent parent = new Parent();

            for (int x = 0; x < secparent.size(); x++) {
                parent.setName("" + secparent.get(i));
                parent.setText1("" + secparent.get(i));




                parent.setText2("");
                parent.setChildren(new ArrayList<Child>());

                // Create Child class object
                final Child child = new Child();

                child.setText1(" " + secchildren.get(i));

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
    private class MyExpandableListAdapter extends BaseExpandableListAdapter
    {


        private LayoutInflater inflater;

        public MyExpandableListAdapter()
        {
            // Create Layout Inflator
            inflater = LayoutInflater.from(TodoSecondPage.this);
        }


        // This Function used to inflate parent rows view

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parentView)
        {
            final Parent parent = parents.get(groupPosition);

            // Inflate grouprow.xml file for parent rows
            convertView = inflater.inflate(R.layout.grouprow, parentView, false);

            // Get grouprow.xml file elements and set values
            TextView tv = ((TextView) convertView.findViewById(R.id.boro));
            tv.setText(parent.getText1());
            tv.setTypeface(font);
            ((TextView) convertView.findViewById(R.id.text)).setText(parent.getText2());





            // Get grouprow.xml file checkbox elements
            checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);

            checkbox.setChecked(parent.isChecked());


            if(parent.isChecked()){
                checkbox.setBackgroundResource(R.drawable.listchecked);
            }else{
                checkbox.setBackgroundResource(R.drawable.listuncheck);
            }


            for(int y=0;y<secparentprog.size();y++){
                if (secparentprog.get(y).equalsIgnoreCase(parent.getText1())){
                    checkbox.setBackgroundResource(R.drawable.listchecked);

                }}
            // Set CheckUpdateListener for CheckBox (see below CheckUpdateListener class)
            checkbox.setOnCheckedChangeListener(new CheckUpdateListener(parent));

            return convertView;
        }


        // This Function used to inflate child rows view
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parentView)
        {
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
        public Object getChild(int groupPosition, int childPosition)
        {
            //Log.i("Childs", groupPosition+"=  getChild =="+childPosition);
            return parents.get(groupPosition).getChildren().get(childPosition);
        }

        //Call when child row clicked
        @Override
        public long getChildId(int groupPosition, int childPosition)
        {
            /****** When Child row clicked then this function call *******/

            //Log.i("Noise", "parent == "+groupPosition+"=  child : =="+childPosition);
            if( ChildClickStatus!=childPosition)
            {
                ChildClickStatus = childPosition;



            }

            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition)
        {
            int size=0;
            if(parents.get(groupPosition).getChildren()!=null)
                size = parents.get(groupPosition).getChildren().size();
            return size;
        }


        @Override
        public Object getGroup(int groupPosition)
        {
            Log.i("Parent", groupPosition + "=  getGroup ");

            return parents.get(groupPosition);
        }

        @Override
        public int getGroupCount()
        {
            return parents.size();
        }

        //Call when parent row clicked
        @Override
        public long getGroupId(int groupPosition)
        {
            Log.i("Parent", groupPosition+"=  getGroupId "+ParentClickStatus);

            if(groupPosition==2 && ParentClickStatus!=groupPosition){


            }

            ParentClickStatus=groupPosition;
            if(ParentClickStatus==0)
                ParentClickStatus=-1;

            return groupPosition;
        }

        @Override
        public void notifyDataSetChanged()
        {
            // Refresh List rows
            super.notifyDataSetChanged();
        }

        @Override
        public boolean isEmpty()
        {
            return ((parents == null) || parents.isEmpty());
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition)
        {
            return true;
        }

        @Override
        public boolean hasStableIds()
        {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled()
        {
            return true;
        }



        /******************* Checkbox Checked Change Listener ********************/

        private final class CheckUpdateListener implements CompoundButton.OnCheckedChangeListener
        {
            private final Parent parent;


            private CheckUpdateListener(Parent parent )
            {
                this.parent = parent;

            }
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("onCheckedChanged", "isChecked: " + isChecked);
                parent.setChecked(isChecked);

                ((MyExpandableListAdapter)getExpandableListAdapter()).notifyDataSetChanged();

                final Boolean checked = parent.isChecked();


                for (int i=0;i<parents.size();i++){
                    if(parent.getName().equalsIgnoreCase(  secparent.get(i)) ){
                        pos=i;
                    }

                }



                if(checked){
                    Calendar cx = Calendar.getInstance();
                    int currentDate = cx.get(Calendar.DATE);
                    int currentMonth = cx.get(Calendar.MONTH);
                    int currentY = cx.get(Calendar.YEAR);


                    Intent intent = new Intent(TodoSecondPage.this, TodoAlarm.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 420, intent, 0);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);

                    setAlarm(currentDate+3,currentMonth+1,currentY,420);
                    percent = temp + percent;

                    //ekhan theke 100% jabe
                    if(percent>=100){

                        getApplicationContext().deleteDatabase("Todo");


                        Intent x=new Intent(TodoSecondPage.this,TodoThirdPage.class);
                        x.putExtra("percent",percent+"");
                        startActivity(x);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        finish();


                    }


                    secparentprog.add(secparent.get(pos));
                    secchildrenprog.add(secchildren.get(pos));
                    TodoProg(secparent.get(pos), secchildren.get(pos));


                }else{

                    Intent intent = getIntent();
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    finish();


                    percent =  percent-temp ;
                    database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

                    sql = "CREATE TABLE IF NOT EXISTS todoprog (Todo VARCHAR ,des VARCHAR  );";
                    c = database.rawQuery(sql, null);

                    database.execSQL(sql);
                    database.execSQL("DROP TABLE IF EXISTS todoprog");
                    for(int i=0;i<secchildrenprog.size();i++){

                        if(!secparentprog.get(i).equalsIgnoreCase(secparent.get(pos))){
                            TodoProg(secparent.get(i), secchildren.get(i));
                        }

                    }




                }

                if(percent>100){
                    percent=100;
                }

                mProgress.setProgress(percent);
                tcounter.setText(percent+"%");



            }

            void TodoProg(String todo, String des ){


                database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

                sql = "CREATE TABLE IF NOT EXISTS todoprog (Todo VARCHAR ,des VARCHAR  );";
                c = database.rawQuery(sql, null);

                database.execSQL(sql);


                String insertSql = "INSERT INTO todoprog VALUES('"+todo+"','"+des+"' );";
                database.execSQL(insertSql);


                database.close();



            }







        }

    }

    void Tododate(String time){


        database = openOrCreateDatabase("Todo",MODE_PRIVATE, null);

        sql = "CREATE TABLE IF NOT EXISTS todotime (Time VARCHAR);";
        c = database.rawQuery(sql, null);

        database.execSQL(sql);


        String insertSql = "INSERT INTO todotime VALUES('"+time+"');";
        database.execSQL(insertSql);


        database.close();



    }
    public void startTimer(){
        SQLiteDatabase     db = openOrCreateDatabase("Todo",MODE_PRIVATE, null);
        String    Sec = "0",Min = "00",Hour = "11";

        String sqxl = "CREATE TABLE IF NOT EXISTS TimeDb (Hour VARCHAR ,Min VARCHAR  ,Sec VARCHAR  );";
        db.execSQL(sqxl);
        String	 dd = "SELECT * from TimeDb;";
        Cursor cd = db.rawQuery(dd, null);



        while (cd.moveToNext()) {


            Hour = cd.getString(cd.getColumnIndex("Hour"));
            Min = cd.getString(cd.getColumnIndex("Min"));
            Sec = cd.getString(cd.getColumnIndex("Sec"));
            Log.e("Created at",""+Min);
        }



        Calendar c = Calendar.getInstance();
        int   chour = c.get(Calendar.HOUR_OF_DAY);

        int   cseconds = c.get(Calendar.SECOND);
        int   cminutes = c.get(Calendar.MINUTE);
        Log.e("current min",""+cminutes);



        if(Integer.parseInt(Hour)>chour){
            hour=Integer.parseInt(Hour)-chour;
        }else{
            hour=(24- chour)+Integer.parseInt(Hour);
        }
        if(hour==24){
            hour=23;
        }



        if(Integer.parseInt(Sec)>cseconds){
            seconds=Integer.parseInt(Sec)-cseconds;
        }else{
            seconds=(60- cseconds)+Integer.parseInt(Sec);
        }
        if(seconds==60){
            seconds=59;
        }



        if(Integer.parseInt(Min)>cminutes){
            minutes=Integer.parseInt(Min)-cminutes;
        }else{
            minutes=(60- cminutes)+Integer.parseInt(Min);
        }
        if(minutes==60){
            minutes=59;
        }






        //Declare the timer
        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {



                        days.setText("Days "+dayCount+"\n Hours\n"+" "+String.valueOf(hour)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)  );
                        seconds -= 1;

                        if(seconds == 0)
                        {
                            days.setText("Days "+dayCount+"\n Hours\n"+" "+String.valueOf(hour)+":"+String.valueOf(minutes)+":"+String.valueOf(seconds)  );


                            seconds=60;
                            minutes=minutes-1;

                        }
                        //ekhan theke less then 100% jabe
                        if(dayCount==0 && minutes==0 && seconds ==0 && hour == 0){
                            getApplicationContext().deleteDatabase("Todo");



                            Intent i=new Intent(TodoSecondPage.this,TodoThirdPage.class);
                            i.putExtra("percent",percent+"");
                            startActivity(i);
                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                            finish();
                        }


                    }

                });
            }

        }, 0, 1000);
    }

    public void setAlarm(int day,int month,int y,int id){


        Calendar cal = Calendar.getInstance();

        int x= (int) System.currentTimeMillis();
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.HOUR_OF_DAY, 11);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DATE, day);


        Intent intent = new Intent(TodoSecondPage.this, TodoAlarm.class);
        PendingIntent examIntent = PendingIntent.getBroadcast(
                TodoSecondPage.this, id, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(android.content.Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), examIntent);



    }


}