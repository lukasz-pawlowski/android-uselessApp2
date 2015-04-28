package com.example.lukaszpp.uselessapp2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    public static long CHRONOBASE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get chronometer
        Chronometer chronoObject = (Chronometer) findViewById(R.id.chronometer);
      //  if(resultsActivity.CHRONOBASE == null) {
            this.CHRONOBASE = resultsActivity.CHRONOBASE;
       // }
        chronoObject.setBase(CHRONOBASE);
        chronoObject.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //definiowanie stałych string
    public final static String NAME = "com.example.lukaszpp.uselessapp2.NAME";
    public final static String SURNAME = "com.example.lukaszpp.uselessapp2.SURNAME";
    public final static String PLACE = "com.example.lukaszpp.uselessapp2.PLACE";
    public final static String CHRONOTIME = "com.example.lukaszpp.uselessapp2.CHRONOTIME";
    public final static String SEEKBARTEXT = "com.example.lukaszpp.uselessapp2.SEEKBARTEXT";



    public void saveButtonClick(View view){

        //get chronometer
        Chronometer chronoObject = (Chronometer) findViewById(R.id.chronometer);
        chronoObject.stop();
        long chronoBase = chronoObject.getBase();
        this.CHRONOBASE = chronoBase;
        String chronoTime = chronoObject.getText().toString();

        //get text
        EditText textFilenameObject = (EditText) findViewById(R.id.textName);
        String name = textFilenameObject.getText().toString();

        textFilenameObject = (EditText) findViewById(R.id.textSurname);
        String surname = textFilenameObject.getText().toString();

        textFilenameObject = (EditText) findViewById(R.id.textPlace);
        String place = textFilenameObject.getText().toString();

        //get progress bar?? how?
        SeekBar seekBarObject = (SeekBar) findViewById(R.id.seekBar);
        String seekBarText = String.valueOf(seekBarObject.getProgress());


        //check if empty


        //create intent
        Intent intent = new Intent(this, resultsActivity.class);


        //push to intent
        intent.putExtra(NAME, name);
        intent.putExtra(SURNAME, surname);
        intent.putExtra(PLACE, place);
        intent.putExtra(SEEKBARTEXT, seekBarText);
        intent.putExtra(CHRONOTIME, chronoTime);

        //wystartowanie aktywnosci
        startActivity(intent);
    }
}
