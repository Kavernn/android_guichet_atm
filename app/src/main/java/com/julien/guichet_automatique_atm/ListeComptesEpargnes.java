package com.julien.guichet_automatique_atm;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListeComptesEpargnes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_comptes_epargnes);

        ArrayList<Epargne> listeComptesEpargnes = new ArrayList<Epargne>();
        initList(listeComptesEpargnes);

        EpargneAdapter adapter = new EpargneAdapter(this, R.layout.activity_liste_comptes_epargnes_layout, listeComptesEpargnes);
        final ListView liste = findViewById(R.id.listeComptesEpargnes);
        liste.setAdapter(adapter);
    }

    private void initList(ArrayList<Epargne> listeComptesEpargne) {

        Epargne e1 = new Epargne(12345, "juvog", 23100);
        listeComptesEpargne.add(e1);

        Epargne e2 = new Epargne(12385, "vinpin", 21220);
        listeComptesEpargne.add(e2);



    }
}
