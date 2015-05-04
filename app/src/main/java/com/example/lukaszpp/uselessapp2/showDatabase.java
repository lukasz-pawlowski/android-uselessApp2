package com.example.lukaszpp.uselessapp2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class showDatabase extends ActionBarActivity {

    private static String DANEPLIKOW = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);


        File dirFiles = getFilesDir();
        for (String strFile : dirFiles.list())
        {
            //wez nazwe pliku
            String filename = strFile;

            this.DANEPLIKOW = this.DANEPLIKOW.toString() + "\n";

            try {
                //pokaz tresc pliku
                FileInputStream fis = openFileInput(filename);
                InputStreamReader inputStreamReader = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);

                }
                this.DANEPLIKOW = this.DANEPLIKOW.toString() + sb.toString() + "\n";

                inputStreamReader.close();
                fis.close();

            }catch (Exception e) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("Blad odczytu do pliku " + filename);
                builder1.setCancelable(true);
                builder1.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert11 = builder1.create();
                alert11.show();
            }


        }

        //pokaz w polu tekstowym
        TextView textViewObject = (TextView) findViewById(R.id.contentPlikow);
        textViewObject.setText(this.DANEPLIKOW.toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_database, menu);
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
