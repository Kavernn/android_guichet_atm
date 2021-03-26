package com.julien.guichet_automatique_atm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    Intent intent = getIntent();
    String utilisateur = intent.getStringExtra(MainActivity.extra_utilisateur);
    int nip = intent.getIntExtra(MainActivity.extra_nip, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_activity);
    }

    public void onClickBtnPaiementInterets(View view) {
    }

    public void onClickBtnComptesCheques(View view) {
        Intent intent = new Intent (this, ListeComptesCheques.class);
        startActivity(intent);

    }

    public void onClickListeClients(View view) {

        Intent intent = new Intent (this, ListeClients.class);
        startActivity(intent);
    }

    public void onClickBtnComptesEpargnes(View view) {
        Intent intent = new Intent (this, ListeComptesEpargnes.class);
        startActivity(intent);
    }
}