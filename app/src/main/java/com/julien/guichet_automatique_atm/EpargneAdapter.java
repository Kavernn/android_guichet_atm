package com.julien.guichet_automatique_atm;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EpargneAdapter extends ArrayAdapter<Epargne> {

    private ArrayList<Epargne> listeComptesEpargnes;
    private int viewRes;
    private Context context;
    private Resources res;

    public EpargneAdapter (Context context, int textViewResourceID, ArrayList<Epargne> listeComptesEpargnes) {
        super(context, textViewResourceID, listeComptesEpargnes);
        this.listeComptesEpargnes= listeComptesEpargnes;
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
        final Epargne epargne = listeComptesEpargnes.get(position);

        if (epargne !=null) {
            TextView solde = (TextView) view.findViewById(R.id.txtSoldeCompteEpargnes);
            TextView noCompte= (TextView) view.findViewById(R.id.txtNumeroComptesEpargnes);



            String epargneSolde = res.getString(R.string.txtSoldeCompte) + " " + epargne.getSoldeCompte() + "$";
            solde.setText(epargneSolde);

            String noEpargne= res.getString(R.string.txtNumeroComptesCheques) + " " + epargne.getNumeroCompte();
            noCompte.setText(noEpargne);
        }
        return view;
    }

}