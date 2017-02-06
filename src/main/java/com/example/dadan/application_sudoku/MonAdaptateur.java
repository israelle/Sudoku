package com.example.dadan.application_sudoku;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

/**
 * Created by dadan on 03/02/2017.
 */

public class MonAdaptateur extends BaseAdapter {

    private ArrayList<VListe> m_liste;

    //Le contexte dans lequel est présent notre adapter
    private Context m_context;

    /**
     * Constructeur par défaut
     */
    public MonAdaptateur(){}

    /**
     * Constructeur
     * @param context
     * @param liste
     */
    public MonAdaptateur(Context context, ArrayList<VListe> liste)
    {

        m_context = context;
        m_liste = liste;

    }


    /**
     * Cette fonction permet de connaître le nombre d'items présent dans la liste
     * @return m_liste.size()
     */
    @Override
    public int getCount() {
        return m_liste.size();
    }

    /**
     * fonction retournant la position de l'objet
     * @param position
     * @return m_liste.get(position)
     */
    @Override
    public Object getItem(int position) {
        return m_liste.get(position);
    }

    /**
     * fonction permettant de connaitre l'identifiant d'un item en fonction de sa position.
     * @param position
     * @return position
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) m_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(m_liste.get(position).getNum() + "   niveau:" + (double) m_liste.get(position).getLevel());
        text2.setText(m_liste.get(position).getDone()+" %");
        text2.setTextSize(22);
        if (m_liste.get(position).getDone() < 40)
            text2.setTextColor(Color.RED);
        else
            text2.setTextColor(Color.GREEN);

        Typeface typeface = Typeface.createFromAsset(m_context.getAssets(), "fonts/Munro.ttf");
        text2.setTypeface(typeface);

        return twoLineListItem;

    }
}
