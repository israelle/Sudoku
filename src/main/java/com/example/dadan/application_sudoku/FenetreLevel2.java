package com.example.dadan.application_sudoku;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FenetreLevel2 extends AppCompatActivity {

    private ListView maListe;
   // private String []values = new  String []{"niveau 1","niveau 2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_level2);



        monObject[] values = new monObject[10] ;
        for (int i =0 ; i<values.length;i++)
        {
            values[i] = new monObject();
        }

        maListe = (ListView) findViewById(R.id.listView);
        ArrayAdapter<monObject>adapter = new ArrayAdapter<monObject>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
        maListe.setAdapter(adapter);
    }

}
