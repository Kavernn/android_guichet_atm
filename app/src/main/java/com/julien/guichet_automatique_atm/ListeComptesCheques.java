package com.julien.guichet_automatique_atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ListeComptesCheques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_comptes_cheques);

        ArrayList<Cheque> listeComptesCheques = new ArrayList<Cheque>();
        //initList(listeComptesCheques);
    }

   /* private void initList(ArrayList<Cheque> listeComptesCheques) {

        Cheque c1 = new Cheque;


    } */
}