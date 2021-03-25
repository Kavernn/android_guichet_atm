package com.julien.guichet_automatique_atm;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClientsAdapter extends ArrayAdapter<Client>{

    private ArrayList<Client> listeClientsList;
    private int viewRes;
    private Context context;
    private Resources res;

    public ClientsAdapter (Context context, int textViewResourceID, ArrayList<Client> listeClients) {
        super(context, textViewResourceID, listeClients);
        this.listeClientsList = listeClients;
        this.context = context;
        this.viewRes = textViewResourceID;
        this.res = context.getResources();

    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
            final Client clients = listeClientsList.get(position);

        if (clients !=null) {
            TextView nom = (TextView) view.findViewById(R.id.nom);
            TextView prenom = (TextView) view.findViewById(R.id.prénom);

            //TODO Problème ici avec la récupération des infos

            String clientNom = res.getString(R.string.nom) + " " + clients.getUsername();
            nom.setText(clientNom);

            String clientPrenom = res.getString(R.string.prenom) + " " + clients.getUser_type();
            prenom.setText(clientPrenom);
        }
        return view;
    }

    @Override
    public int getCount () {

        return listeClientsList.size();

    }
}


