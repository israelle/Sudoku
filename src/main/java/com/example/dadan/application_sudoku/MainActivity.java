package com.example.dadan.application_sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class monObject{

    public monObject(){

    }
    public String toString(){
        return " TOTO";
    }


}
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button level1;
    private Button level2;
    private Button level3;

    AppCompatActivity lecontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lecontext = this;
        //initialisation des boutons
        level1 = (Button) findViewById(R.id.buttonLevel1);
        level1.setOnClickListener(this);
        level2 = (Button) findViewById(R.id.buttonLevel2);
        level2.setOnClickListener(this);
        level3 = (Button) findViewById(R.id.buttonLevel3);
        level3.setOnClickListener(this);

    }



            public void onClick(View v) {
            Intent intention  = new Intent(lecontext, FenetreLevel1.class);
                int buttonlevel= 0;
            if (v==level1)
            {

                intention  = new Intent(lecontext, FenetreLevel1.class);
                buttonlevel=1;


            } else if (v==level2)

            {
                intention = new Intent(lecontext, FenetreLevel1.class);
                buttonlevel=2;


            } else if (v==level3)

            {
                intention = new Intent(lecontext, FenetreLevel1.class);
                buttonlevel = 3;


            }
                intention.putExtra("key",buttonlevel);
                startActivity(intention);


        }


}
