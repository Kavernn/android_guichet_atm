package com.julien.guichet_automatique_atm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeComptesCheques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_comptes_cheques);

        ArrayList<Cheque> listeComptesCheques = new ArrayList<Cheque>();
        initList(listeComptesCheques);

        ChequeAdapter adapter = new ChequeAdapter(this, R.layout.activity_liste_comptes_cheques_layout, listeComptesCheques);
        final ListView liste = findViewById(R.id.listeComptesCheques);
        liste.setAdapter(adapter);
    }

    private void initList(ArrayList<Cheque> listeComptesCheques) {

       Cheque c1 = new Cheque(12345, "juvog", 5000);
       listeComptesCheques.add(c1);

        Cheque c2 = new Cheque(12385, "vinpin", 2000);
        listeComptesCheques.add(c2);



    }
}