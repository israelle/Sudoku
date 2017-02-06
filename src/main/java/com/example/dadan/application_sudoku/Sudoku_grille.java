package com.example.dadan.application_sudoku;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Sudoku_grille extends AppCompatActivity {

    private static final int COLONNE = 9;
    private static final int LIGNE = 9;
    /*tableau à deux dimensions 81 cases*/
    private int m_grille [][] = new int [LIGNE][COLONNE];

    AppCompatActivity contexte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_grille2);

        contexte = this;

        //récupération du numero de grille
        String grille = (String) this.getIntent().getExtras().get("grille");

        int cpt = 0;
        //parcours du tableau à deux dimension et initialisation de chaque case
        for (int i = 0; i < LIGNE; i++){
            for (int j = 0; j < COLONNE; j++){
                m_grille[j][i] = Integer.parseInt(""+ grille.charAt(cpt));
                cpt++;

            }
        }

        Dessin_grille dessin = (Dessin_grille) findViewById(R.id.dessin);
        dessin.setGrille(m_grille);


    }


}
