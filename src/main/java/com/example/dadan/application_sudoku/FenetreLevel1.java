package com.example.dadan.application_sudoku;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FenetreLevel1 extends AppCompatActivity {

    private ListView maListe;
    private Intent intent;
    final static int NB_MAX_LISTE = 100;
    private AppCompatActivity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenetre_level1);
        context = this;
        intent = getIntent();
        //Bundle objetbundle = getIntent().getExtras();

        Bundle bun = getIntent().getExtras();
        int choix = bun.getInt("key");
        maListe = (ListView) findViewById(R.id.listView);

        //déclaration d'un tableau de 100 case de type VListe
        VListe[] values = new VListe[NB_MAX_LISTE] ;
        ArrayList<VListe>m_values = new ArrayList<VListe>();

        //création de la liste de Grilles
        for (int i =0 ; i<NB_MAX_LISTE;i++)
        {
            m_values.add(new VListe(choix,i+1,nombreAleatoire()));
            MonAdaptateur monAdaptateur = new MonAdaptateur(context,m_values);

            maListe.setAdapter(monAdaptateur);

        }


        maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // l'index de l'item dans notre ListView
                int itemPosition = position;

                //gestion popup
                 AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Information");
                // On récupère le texte de l'item cliqué
                final VListe itemValue = (VListe) maListe.getItemAtPosition(position);
                builder.setMessage("\n Niveau :"+itemValue.getLevel()+"\n Grille n° "+itemValue.getNum()+"\n Fini à : "+itemValue.getDone() );
                builder.setCancelable(false);
                builder.setNeutralButton("continuer",new DialogInterface.OnClickListener() {

                    /**
                     *
                     * @param dialog
                     * @param which
                     */
                    public void onClick(DialogInterface dialog, int which) {
                        //passage d'une vue à une autre
                        Intent intent = new Intent(FenetreLevel1.this, Dessin_grille.class);
                        intent.putExtra("grille", itemValue.getNum());
                        startActivity(intent);
                    }
                });


                // cas ou l'utilisateur appuie sur non, il retourne à la liste des grilles
                builder.setNegativeButton("Annuler",null);
                AlertDialog alert = builder.create();
                alert.show();

            }
        });




    }



    /**
     * fonction retournant un nombre aléatoire
     * @return res
     */
    int nombreAleatoire ()
    {
        int max = 100;
        int min = 0;

        int res = (int)(min+ Math.random()*(max-min));
        return res;
    }

}
