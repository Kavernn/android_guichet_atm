package com.julien.guichet_automatique_atm;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChequeAdapter extends ArrayAdapter<Cheque> {

        private ArrayList<Cheque> listeComptesCheques;
        private int viewRes;
        private Context context;
        private Resources res;

        public ChequeAdapter (Context context, int textViewResourceID, ArrayList<Cheque> listeComptesCheques) {
            super(context, textViewResourceID, listeComptesCheques);
            this.listeComptesCheques= listeComptesCheques;
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
            final Cheque cheques = listeComptesCheques.get(position);

            if (cheques !=null) {
                TextView solde = (TextView) view.findViewById(R.id.txtSoldeCompte);
                TextView noCompte= (TextView) view.findViewById(R.id.txtNumeroComptesCheques);



                String chequeSolde = res.getString(R.string.txtSoldeCompte) + " " + cheques.getSoldeCompte() + "$";
                solde.setText(chequeSolde);

                String noCheques= res.getString(R.string.txtNumeroComptesCheques) + " " + cheques.getNumeroCompte();
               noCompte.setText(noCheques);
            }
            return view;
        }

}