package com.example.dadan.application_sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Dessin_grille  extends View implements View.OnTouchListener {

    private AppCompatActivity contexte;

    private  int value;
    private int [][] grille = null;

    private Paint m_paint;

    public Dessin_grille(Context context, AttributeSet attrs){
        super(context, attrs);
       // cercles =  new LinkedList<Cercle>();
        this.setOnTouchListener(this);
        m_paint = new Paint();

    }

    /**
     *
     * @param canvas
     */
    public void onDraw(Canvas canvas){
        Paint dessin = new Paint();

        drawNumber(canvas);
        drawLines(canvas);
    }

    /**
     * methode affichant les nombres
     * @param canvas
     */
    public void drawNumber(Canvas canvas){
        m_paint.setColor(Color.BLACK);
        m_paint.setTextSize(60);
        m_paint.setStyle(Paint.Style.FILL);

        Rect bounds = new Rect();
        m_paint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds);

        if( getValue() != 0 ){
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width())/2, (getHeight() + bounds.height())/2	, m_paint);
        }
    }

    /**
     * methode dessinant le cadrillage du sudoku
     * @param canvas
     */
    private void drawLines(Canvas canvas) {
        m_paint.setColor(Color.BLACK);
        m_paint.setStyle(Paint.Style.STROKE);

        m_paint.setStrokeWidth(5);
        canvas.drawLine(50, 50, 950, 50, m_paint);
        canvas.drawLine(50, 150, 950, 150, m_paint);
        canvas.drawLine(50, 250, 950, 250, m_paint);
        m_paint.setStrokeWidth(10);
        canvas.drawLine(50, 350, 950, 350, m_paint);
        m_paint.setStrokeWidth(5);
        canvas.drawLine(50, 450, 950, 450, m_paint);
        canvas.drawLine(50, 550, 950, 550, m_paint);
        m_paint.setStrokeWidth(10);
        canvas.drawLine(50, 650, 950, 650, m_paint);
        m_paint.setStrokeWidth(5);
        canvas.drawLine(50, 750, 950, 750, m_paint);
        canvas.drawLine(50, 850, 950, 850, m_paint);
        canvas.drawLine(50, 950, 950, 950, m_paint);

        canvas.drawLine(50, 50, 50, 950, m_paint);
        canvas.drawLine(150, 50, 150, 950, m_paint);
        canvas.drawLine(250, 50, 250, 950, m_paint);
        m_paint.setStrokeWidth(10);
        canvas.drawLine(350, 50, 350, 950, m_paint);
        m_paint.setStrokeWidth(5);
        canvas.drawLine(450, 50, 450, 950, m_paint);
        canvas.drawLine(550, 50, 550, 950, m_paint);

        m_paint.setStrokeWidth(10);
        canvas.drawLine(650, 50, 650, 950, m_paint);
        m_paint.setStrokeWidth(5);
        canvas.drawLine(750, 50, 750, 950, m_paint);
        canvas.drawLine(850, 50, 850, 950, m_paint);
        canvas.drawLine(950, 50, 950, 950, m_paint);
        canvas.drawRect(0, 0, getWidth(), getHeight(), m_paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        /*** Evenement utilisant les coordonnées x et y***/
        int x =(int)event.getX();
        int y =(int)event.getY();

        int xUp;
        int yUp;

        /**** Switch sur les différentes action ****/
        switch (event.getAction()){
            /**** Début d'une pression ****/
            case MotionEvent.ACTION_DOWN:
                for(int i=1;i<=9;i++){
                    /** *i permet de parcourir les 9 boutons **/
                    if(x >= getWidth()/10*i-50 && x <=  getWidth()/10*i+50 && y >=  getWidth()+50 && y <=  getWidth()+150){
                        value = i;
                    }
                }
                break;

            /**** Fin d'une pression ****/
            case MotionEvent.ACTION_UP:
                xUp = x / (getWidth() /9);
                yUp = y / (getWidth() /9);
                if (xUp <9 && yUp <9){
                    grille[xUp][yUp] = value;
                }

                /*** Force le dessin ***/
                invalidate();

                value = 0;
                break;
        }

        this.invalidate();
        return true;
    }

    /**
     * getter
     * @return value
     */
    public int getValue() {
        return value;
    }


    /**
     *
     * @param grille
     */
    public void setGrille(int[][] grille){
        this.grille = grille;
    }


}
