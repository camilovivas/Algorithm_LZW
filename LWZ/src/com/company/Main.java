package com.company;

import java.util.ArrayList;

public class Main {
    private ArrayList<String> fraseSplit;
    private ArrayList<String> w;
    private ArrayList<String> k;
    private ArrayList<String> wk;
    private ArrayList<Integer> salida;
    private ArrayList<String> dicc;

    public Main(){
        fraseSplit = new ArrayList<>();
        w = new ArrayList<>  ();
        k = new ArrayList<> ();
        wk = new ArrayList<> ();
        dicc = new ArrayList<> ();
        salida = new ArrayList<> ();

    }
    public static void main(String[] args) {
	    Main m = new Main();
	    m.separarFrase ( "MI MAMA ME MIMO A MI" );
	    m.separarletras ();
	    m.LZW ();
    }

    public void separarletras(){
        for (int i = 0; i < fraseSplit.size (); i++) {
            if(!dicc.contains (fraseSplit.get (i))){
                dicc.add (fraseSplit.get (i));
                System.out.println (fraseSplit.get (i));
            }
        }
    }

    public void separarFrase(String frase){
        for(int i=0; i< frase.length (); i++){
            String f = String.valueOf ( frase.charAt ( i ) );
            fraseSplit.add (f);
        }
    }

    public void LZW(){
        w.add ( "null" );
        int contador = 0;
        while(contador < fraseSplit.size ()){
            k.add ( fraseSplit.get ( contador ) );
            String wk2 = w.get ( w.size ()-1 )+ k.get (k.size ()-1 );
            if(contador == 0){
                wk.add(k.get (k.size ()-1 ));
                w.add (k.get (k.size ()-1 ));
                contador++;
            }
            else {
                if ( dicc.contains ( wk2 ) ) {
                    wk.add ( wk2 );
                    w.add ( wk2 );
                    contador++;
                } else {
                    salida.add ( dicc.indexOf ( w.get ( w.size ()-1 ) ) );
                    dicc.add ( wk2 );
                    wk.add ( wk2 );
                    w.add ( k.get ( k.size ( ) - 1 ) );
                    contador++;
                }
            }
        }
        salida.add ( dicc.indexOf ( w.get ( w.size ()-1 ) ) );
    }



}
