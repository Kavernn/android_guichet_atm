package com.julien.guichet_automatique_atm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class GuichetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guichet);
    }

    //  SAUVEGARDE DE L'ÉTAT AFIN DE POUVOIR UTILISER L'ACTIVITÉ EN MODE PAYSAGE
    //Récupération et initialisation des variables qui vont être placées dans le Bundle
    // Montant de la transaction
    EditText montant = (EditText) findViewById(R.id.etxtMontant);
    float le_montant = Float.parseFloat(montant.getText().toString());
    private static final String cleMontant = "Montant";


    //Choix de la transaction
    RadioGroup transaction = (RadioGroup)findViewById(R.id.rdgChoixAction);
    int sel_transaction = transaction.getCheckedRadioButtonId();
    private static final String cleTransaction = "Transaction";

    //Choix du compte
    RadioGroup compte = (RadioGroup)findViewById(R.id.rdgChoixCompte);
    int sel_compte = transaction.getCheckedRadioButtonId();
    private static final String cleCompte = "Transaction";

    private Bundle SavedInstanceState;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(SavedInstanceState);
        savedInstanceState.putFloat(cleMontant, le_montant);
        savedInstanceState.putInt(cleTransaction, sel_transaction);
        savedInstanceState.putInt(cleCompte, sel_compte);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            le_montant = savedInstanceState.getFloat(cleMontant, le_montant);
            sel_transaction = savedInstanceState.getInt(cleTransaction, sel_transaction);
            sel_compte = savedInstanceState.getInt(cleTransaction, sel_compte);
        }

    }




    public void onClickBtnDeconnexion(View view) {
    }


    // Méthodes onClick du pavé numérique

    public void onClickBtn1(View view) {
    }

    public void onClickBtn2(View view) {
    }

    public void onClickBtn3(View view) {
    }

    public void onClickBtn4(View view) {
    }

    public void onClickBtn5(View view) {
    }

    public void onClickBtn6(View view) {
    }

    public void onClickBtn7(View view) {
    }

    public void onClickBtn8(View view) {
    }

    public void onClickBtn9(View view) {
    }

    public void onClickBtn0(View view) {
    }

    public void onClickBtnPoint(View view) {
    }

    public void onClickBtnC(View view) {
    }

    //Méthodes onClick sur les radioGroup rdgChoixAction et rdgChoixCompte

    public void onClickChoixAction(View view) {
    }

    public void onClickChoixCompte(View view) {
    }




    // Méthodes onClick qui permettent de finaliser la transaction et de montrer l'état des comptes.

    public void onClickEtat(View view) {
    }

    public void onClickSoumettre(View view) {
    }



}


