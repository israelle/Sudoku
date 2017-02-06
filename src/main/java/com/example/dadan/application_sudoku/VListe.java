package com.example.dadan.application_sudoku;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

/**
 * Created by israelle lagier on 03/02/2017.
 */

public class VListe extends Activity {

    private int level;
    private int num;
    private int done;

    /**
     * Constructeur par défaut
     */
    public VListe(){}

    /**
     * Constructeur
     * @param level niveau choisi
     * @param num   numero
     * @param done  pourcentage
     */
    public VListe (int level, int num, int done)
    {
        this.level = level;
        this.num = num;
        this.done = done;
    }

    /**
     * la méthode déclenche lors d'un clic sur
     * le nom d'une personne. Une popup s'ouvrira pour donner le nom de la grille cliqué.
     * @param item
     *
     */
    public void onClickGrille(VListe item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Validation");

        builder.setMessage("Vous avez cliqué sur : "+item.toString());
        builder.setPositiveButton("Oui", null);
        builder.setNegativeButton("Non", null);

        builder.show();
    }

    /*Getters et Setters */
    public int getLevel() {return level;}
    public void setLevel(int l) {level = l;}
    public int getNum(){ return num;}
    public void setNum(int n){ num = n;}
    public int getDone(){return done;}
    public void setDone(int d){ done = d;}

    /**
     * fonction retournant une chaine de caractère
     * @return
     */
   public String toString()
    {
        return num+ " "+"niveau : "+level+" "+"\n"+done+" %";
    }
}
