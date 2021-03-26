package com.julien.guichet_automatique_atm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class GuichetActivity  extends AppCompatActivity {

    // Valeur des clés pour la restoration des paramètres OnSaveInstanceState() et OnRestoreInstanceState()
    static String cleMontant = "Montant";
    static String cleTransaction = "Transaction";
   static  String cleCompte = "Compte";

    // Récipération des valeurs nip et utilisateur provenant de MainActivity
    Intent intent = getIntent();
    String utilisateur = intent.getStringExtra(MainActivity.extra_utilisateur);
    int nip = intent.getIntExtra(MainActivity.extra_nip, 0);

    // Création d'un objet Guichet et recherche des comptes  associés à l'utilisateur.
    Guichet guichet = new Guichet();
    Compte le_compte_cheque = guichet.trouverCompteCheque(nip, utilisateur);
    Compte le_compte_epargne = guichet.trouverCompteEpargne(nip, utilisateur);

    // Récupérer le montant écrit par l'utilisateur
    EditText montant = (EditText) findViewById(R.id.etxtMontant);
    double le_montant = Double.parseDouble(montant.getText().toString());

    //Récupérer l'id du bouton transaction sélectionné par l'utilisateur
    RadioGroup transaction = (RadioGroup) findViewById(R.id.rdgChoixAction);
    int choix_transaction = transaction.getCheckedRadioButtonId();

    // Récupérer l'id du bouton "compte" sélectionné par l'utilisateur
    RadioGroup compte = (RadioGroup) findViewById(R.id.rdgChoixCompte);
    int choix_compte = compte.getCheckedRadioButtonId();

    // Liste des id des boutons
    final int choix_epargne = R.id.rdbEpargne;
    final int choix_cheque = R.id.rdbCheque;

    final int choix_depot = R.id.rdbDepot;
    final int choix_retrait = R.id.rdbRetrait;
    final int choix_virement = R.id.rdbVirement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guichet);

        //Ajout des clients (Est ce nécessaire de le rajouter si c'est présent sur l'activité MainActivity ?)
        guichet.addClient("Sijlamassi", "Hicham", "hichamsijlamassi", 12345);
        guichet.addClient("Vogler", "Julien", "julienvogler", 12345);
        guichet.addClient("Pinard", "Vincent", "pinardvincent", 12345);
        guichet.addAdmin("Hicham", "admin");
        //Ajout des comptes cheque
        guichet.addCompteCheque("hichamsijlamassi", 12345);
        guichet.addCompteCheque("julienvogler", 12345);
        guichet.addCompteCheque("pinardvincent", 12345);

        //Ajout des comptes Epargne
        guichet.addCompteEpargne("hichamsijlamassi", 12345);
        guichet.addCompteEpargne("julienvogler", 12345);
        guichet.addCompteEpargne("pinardvincent", 12345);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        RadioGroup rdgTransaction = (RadioGroup) findViewById(R.id.rdgChoixAction);
        RadioGroup rdgCompte = (RadioGroup) findViewById(R.id.rdgChoixCompte);

        //Récupérer le radioBouton Transaction et le mettre dans le Bundle
        int id_btnTransaction = rdgTransaction.getCheckedRadioButtonId();
        savedInstanceState.putInt(cleTransaction, id_btnTransaction);

        //Récupérer le radioBouton compte et le mettre dans le Bundle
        int id_btnCompte = rdgCompte.getCheckedRadioButtonId();
        savedInstanceState.putInt(cleCompte, id_btnCompte);


        //Récupérer le montant de la transaction
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        float le_montant = Float.parseFloat(montant.getText().toString());
        savedInstanceState.putFloat(cleMontant, le_montant);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {

            RadioGroup rdgTransaction = (RadioGroup) findViewById(R.id.rdgChoixAction);
            RadioGroup rdgCompte = (RadioGroup) findViewById(R.id.rdgChoixCompte);

            //Récupérer le montant et le mettre dans le EditTexte montant
            EditText montant = (EditText) findViewById(R.id.etxtMontant);
            float le_montant = savedInstanceState.getFloat(cleMontant, 0);
            montant.setText(String.valueOf(le_montant));

            //Conserver le radiobouton transaction qui est coché
            rdgTransaction.check(savedInstanceState.getInt(cleTransaction, 0));

            //Conserver le radiobouton compte qui est coché
            rdgCompte.check(savedInstanceState.getInt(cleCompte, 0));
        }
    }


    public void onClickBtnDeconnexion(View view) {
        finish();
        System.exit(0);
    }


    public void onClickBtn1(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"1";

        montant.setText(montantTxt);

    }

    public void onClickBtn2(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"2";
        montant.setText(montantTxt);
    }

    public void onClickBtn3(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"3";
        montant.setText(montantTxt);
    }

    public void onClickBtn4(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"4";
        montant.setText(montantTxt);
    }

    public void onClickBtn5(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"5";
        montant.setText(montantTxt);
    }

    public void onClickBtn6(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"6";
        montant.setText(montantTxt);
    }

    public void onClickBtn7(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"7";
        montant.setText(montantTxt);
    }

    public void onClickBtn8(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"8";
        montant.setText(montantTxt);
    }

    public void onClickBtn9(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"9";
        montant.setText(montantTxt);
    }

    public void onClickBtn0(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +"0";
        montant.setText(montantTxt);
    }

    public void onClickBtnPoint(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = montant.getText().toString() +".";
        montant.setText(montantTxt);
    }

    public void onClickBtnC(View view) {
        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        String montantTxt = "";
        montant.setText(montantTxt);
    }


    //Méthodes onClick sur le radioGroup rdgChoixAction
    RadioGroup rdgTransaction = (RadioGroup) findViewById(R.id.rdgChoixAction);
    RadioGroup rdgCompte = (RadioGroup) findViewById(R.id.rdgChoixCompte);
    public void onClickDepot(View view) {
        rdgTransaction.check(R.id.rdbDepot);
    }

    public void onClickRetrait(View view) {
        rdgTransaction.check(R.id.rdbRetrait);
    }

    public void onClickVirement(View view) {
        rdgTransaction.check(R.id.rdbVirement);
    }

    //Méthodes onClick sur le radioGroup rdgChoixCompte

    public void onClickCheque(View view) {
        rdgCompte.check(R.id.rdbCheque);
    }

    public void onClickEpargne(View view) {
        rdgCompte.check(R.id.rdbEpargne);
    }


    public void onClickEtat(View view) {

        Toast.makeText(this,  le_compte_cheque.toString() +  "\n"+ le_compte_epargne.toString(), 4).show();

    }


    public void onClickSoumettre(View view) {


        switch (choix_transaction) {

            case choix_depot:

                if (choix_compte == choix_epargne) {
                    // Le solde final du compte ne doit pas dépassé 100000$
                    if ((le_compte_epargne.getSoldeCompte() + le_montant) > 100000){
                        Toast.makeText(this, "Transaction refusée : le solde final du compte épargne dépasse la limite autorisée.", 2).show();
                    }
                    // Ajout du montant sur le compte épargne
                    else {
                        double nouveau_solde_epargne = le_compte_epargne.getSoldeCompte() + le_montant;
                        le_compte_epargne.setSoldeCompte(nouveau_solde_epargne);
                        Toast.makeText(this, "Nouveau solde du compte épargne : " + nouveau_solde_epargne + " $.", 2).show();
                    }
                } else if (choix_compte == choix_cheque) {

                    // Le solde final du compte ne doit pas dépassé 100000$
                    if ((le_compte_cheque.getSoldeCompte() + le_montant) > 100000){
                        Toast.makeText(this, "Transaction refusée : le solde final du compte chèque dépasse la limite autorisée.", 2).show();
                    }
                    // Ajout du montant sur le compte chèque
                    else {
                        double nouveau_solde_cheque = le_compte_cheque.getSoldeCompte() + le_montant;
                        le_compte_cheque.setSoldeCompte(nouveau_solde_cheque);
                        Toast.makeText(this, "Nouveau solde su compte chèque : " + nouveau_solde_cheque + " $.", 2).show();
                    }
                } else {
                    Toast.makeText(this, "Aucun type de transaction n'est selectionné", 2).show();
                }
                break;


            case choix_retrait:
                // On ne peut pas faire un retrait de plus de 1000$ et le montant doit être un multiple de 10$.
                if ((le_montant >= 1000) || (le_montant%10 != 0)) {
                    Toast.makeText(this, "Attention ! \n Retrait maximal autorisé : 1000$. \n Vous devez saisir un montant multiple de 10", 2).show();

                    // Retrait du compte épargne
                } else if (choix_compte == choix_epargne) {
                    double solde_epargne = le_compte_epargne.getSoldeCompte();
                    if (le_montant > solde_epargne){
                        Toast.makeText(this, "Fonds insuffisants ", 2).show();
                    }
                    else {double nouveau_solde_epargne = guichet.retraitEpargne(nip, utilisateur, le_montant);
                        Toast.makeText(this, "Nouveau solde du compte épargne : " + solde_epargne + " $.", 2).show();
                    }

                    // Retrait du compte chèque
                } else if (choix_compte == choix_cheque) {
                    double solde_cheque = le_compte_cheque.getSoldeCompte();
                    if (le_montant > solde_cheque) {
                        Toast.makeText(this, "Fonds insuffisants ", 2).show();
                    } else {
                        double nouveau_solde_cheque = guichet.retraitEpargne(nip, utilisateur, le_montant);
                        Toast.makeText(this, "Nouveau solde du compte chèque : " + nouveau_solde_cheque + " $.", 2).show();
                    }
                }
                break;

            case choix_virement:

                // On ne peut pas faire de virements de plus de 100000$
                if (le_montant >= 100000) {
                    Toast.makeText(this, "Vous n'êtes pas autorisés à faire une transaction de plus de 100000$", 2).show();

                    // Virement de chèque vers épargne
                } else if (choix_compte == choix_epargne) {

                    // 1. Compte à débiter = compte cheque
                    double solde_cheque = le_compte_cheque.getSoldeCompte();
                    if (solde_cheque < le_montant) {
                        Toast.makeText(this, "Vous n'avez pas le montant suffisant sur votre compte chèque", 2).show();
                    } else {
                        le_compte_cheque.retrait(le_montant);

                        // 2. Compte à créditer : compte épargne
                        le_compte_epargne.depot(le_montant);
                        double nouveau_solde_cheque = le_compte_cheque.getSoldeCompte();
                        double nouveau_solde_epargne = le_compte_epargne.getSoldeCompte();
                        Toast.makeText(this, "Solde compte chèque : " + nouveau_solde_cheque + " $. \nSolde compte chèque : " + nouveau_solde_epargne + " $.", 2).show();
                    }

                    // Virement de épargne vers chèque
                } else if (choix_compte == choix_cheque) {
                    // 1. Compte à débiter = compte épargne
                    double solde_epargne = le_compte_epargne.getSoldeCompte();
                    if (solde_epargne < le_montant) {
                        Toast.makeText(this, "Vous n'avez pas le montant suffisant sur votre compte épargne", 2).show();
                    } else {
                        le_compte_epargne.retrait(le_montant);

                        // 2. Compte à créditer : compte chèque
                        le_compte_cheque.depot(le_montant);
                        double nouveau_solde_cheque = le_compte_cheque.getSoldeCompte();
                        double nouveau_solde_epargne = le_compte_epargne.getSoldeCompte();
                        Toast.makeText(this, "Solde compte chèque : " + nouveau_solde_cheque + " $. \nSolde compte chèque : " + nouveau_solde_epargne + " $.", 2).show();
                    }
                }


        }


    }


}


