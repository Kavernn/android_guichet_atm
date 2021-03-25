package com.julien.guichet_automatique_atm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListeClients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_clients);

        ArrayList<Client> listeClients = new ArrayList<Client>();
        initList(listeClients);

        ClientsAdapter adapter = new ClientsAdapter(this, R.layout.activite_liste_clients_layout, listeClients);
        final ListView liste = findViewById(R.id.listeClients);
        liste.setAdapter(adapter);

    }

    private void initList(ArrayList<Client> listeClients) {

        //initialisation de ce qui va peupler ACTIVITE_LISTE_CLIENTS.xml

        Client julien = new Client("Vogler", "Julien", "juvog", 12345);
        Client hicham = new Client("Sijlamassi", "Hicham", "hisijl", 56789);
        Client vincent = new Client ("Pinard", "Vincent", "vipin", 54321);

        listeClients.add(julien);
        listeClients.add(hicham);
        listeClients.add(vincent);

    }
}