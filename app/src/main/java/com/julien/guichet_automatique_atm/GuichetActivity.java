package com.julien.guichet_automatique_atm;

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


public class GuichetActivity extends AppCompatActivity {

    static String cleMontant = "Montant";
    static String cleTransaction = "Transaction";
   static  String cleCompte = "Compte";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guichet);
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

    }


    // Méthodes onClick du pavé numérique

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

    //Méthodes onClick sur les radioGroup rdgChoixAction et rdgChoixCompte

    public void onClickChoixAction(View view) {



    }



    public void onClickChoixCompte(View view) {


    }



    // Méthodes onClick qui permettent de finaliser la transaction et de montrer l'état des comptes.

    public void onClickEtat(View view) {


    }

    // Lors d'un clique sur le bouton soumettre uen transaction
    public void onClickSoumettre(View view) {

        EditText montant = (EditText) findViewById(R.id.etxtMontant);
        double le_montant = Double.parseDouble(montant.getText().toString());

        RadioGroup transaction = (RadioGroup) findViewById(R.id.rdgChoixAction);
        int choix_transaction = transaction.getCheckedRadioButtonId();

        final int choix_depot = R.id.rdbDepot;
        final int choix_retrait = R.id.rdbRetrait;
        final int choix_virement = R.id.rdbVirement;

        RadioGroup compte = (RadioGroup) findViewById(R.id.rdgChoixCompte);
        int choix_compte = compte.getCheckedRadioButtonId();

        int choix_epargne = R.id.rdbEpargne;
        int choix_cheque = R.id.rdbCheque;


        switch (choix_transaction){
// Julien
            case choix_depot :
                if (choix_compte  == choix_epargne) {
                    //aller récupérer le compte de la personne concerrnée


                    // Utiliser la méthode ajouterMontant() de la classe épargne



                }else if (choix_compte ==choix_cheque)  {



                    // Utiliser la méthode ajouterMontant() de la classe chèque





                } else {
                    Toast.makeText(this, "Aucun compte n'est selectionné", 2).show();
                }
                break;



                // Hicham
            case choix_retrait :
                if (choix_compte ==choix_epargne){
                    // Utiliser la méthode retirerMontant() de la classe épargne
                }
                else if (choix_compte ==choix_cheque) {
                    // Utiliser la méthode retirerMontant() de la classe cheque
                }
                else {
                    Toast.makeText(this, "Aucun compte n'est selectionné", 2).show();
                };
                break;

            case choix_virement :

                if (choix_compte ==choix_epargne){
                    // Utiliser la méthode virerVersCheque() de la classe épargne
                }
                else if (choix_compte ==choix_cheque){
                    // Utiliser la méthode virerVersEpargne() de la classe cheque
                }
                else {
                    Toast.makeText(this, "Aucun compte n'est selectionné", 2).show();

                };
                break;

            default :
                Toast.makeText(this, "Aucun type de transaction n'est sélectionné", 2).show();
                break;

        }


    }





}


