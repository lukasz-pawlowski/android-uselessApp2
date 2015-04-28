package com.example.lukaszpp.uselessapp2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.TextView;


public class resultsActivity extends ActionBarActivity {

    //global
   // public static long CHRONOBASE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String name = getIntent().getStringExtra(MainActivity.NAME);
        String surname = getIntent().getStringExtra(MainActivity.SURNAME);
        String place = getIntent().getStringExtra(MainActivity.PLACE);
        String chronoTime = getIntent().getStringExtra(MainActivity.CHRONOTIME);
        String seekBarText = getIntent().getStringExtra(MainActivity.SEEKBARTEXT);

        //chrono base

       // this.CHRONOBASE = MainActivity.CHRONOBASE;
        Chronometer chronoObject = (Chronometer) findViewById(R.id.chronometer2);
     //   chronoObject.setBase(MainActivity.CHRONOBASE);
        chronoObject.setBase(MainActivity.CHRONOBASE);
        chronoObject.setText(MainActivity.CHRONOTEXT);
        chronoObject.start();

        //set new text

        //imie
        TextView textViewObject = (TextView) findViewById(R.id.textView5);
        textViewObject.setText("Imie: "+name);

        //nazwisko
        textViewObject = (TextView) findViewById(R.id.textView6);
        textViewObject.setText("Nazwisko: "+surname);

        //miejsce
        textViewObject = (TextView) findViewById(R.id.textView7);
        textViewObject.setText("Miejsce: "+place);

        //czas
        textViewObject = (TextView) findViewById(R.id.textView8);
        textViewObject.setText("Czas: " +MainActivity.CHRONOTEXT);

        //seek bar
        textViewObject = (TextView) findViewById(R.id.textView9);
        textViewObject.setText("Lubisz uczelnie na: "+seekBarText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
