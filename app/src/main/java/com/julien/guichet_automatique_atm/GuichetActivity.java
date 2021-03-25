package com.julien.guichet_automatique_atm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class GuichetActivity extends AppCompatActivity {

    //Instanciation des boutons
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9
            , buttonPoint, buttonC, buttonEtatComptes, buttonSoumettre, buttonLogOut;
    EditText montant = (EditText) findViewById(R.id.etxtMontant);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guichet);
    }

    //  SAUVEGARDE DE L'ÉTAT AFIN DE POUVOIR UTILISER L'ACTIVITÉ EN MODE PAYSAGE
    //Récupération et initialisation des variables qui vont être placées dans le Bundle
    // Montant de la transaction

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

    //@Override
    //protected void onSaveInstanceState(Bundle savedInstanceState) {
       // super.onSaveInstanceState(SavedInstanceState);
         //  savedInstanceState.putFloat(cleMontant, le_montant);
         // savedInstanceState.putInt(cleTransaction, sel_transaction);
         // savedInstanceState.putInt(cleCompte, sel_compte);
   // }
   // @Override
  //  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
      //  super.onRestoreInstanceState(savedInstanceState);
      //  if (savedInstanceState != null) {
         //   le_montant = savedInstanceState.getFloat(cleMontant, le_montant);
         ///   sel_transaction = savedInstanceState.getInt(cleTransaction, sel_transaction);
          //  sel_compte = savedInstanceState.getInt(cleTransaction, sel_compte);
      //  }

  //  }




    public void onClickBtnDeconnexion(View view) {


        buttonLogOut = findViewById(R.id.buttonDeconnexion);
    }


    // Méthodes onClick du pavé numérique

    public void onClickBtn1(View view) {


        button1 = findViewById(R.id.button);
        montant.setText(montant.getText() + "1");
    }

    public void onClickBtn2(View view) {

        button2 = findViewById(R.id.button2);
        montant.setText(montant.getText() + "2");
    }

    public void onClickBtn3(View view) {


        button3 = findViewById(R.id.button3);
        montant.setText(montant.getText() + "3");
    }

    public void onClickBtn4(View view) {


        button4 = findViewById(R.id.button4);
        montant.setText(montant.getText() + "4");
    }

    public void onClickBtn5(View view) {


        button5 = findViewById(R.id.button5);
        montant.setText(montant.getText() + "5");
    }

    public void onClickBtn6(View view) {


        button6 = findViewById(R.id.button6);
        montant.setText(montant.getText() + "6");
    }

    public void onClickBtn7(View view) {


        button7 = findViewById(R.id.button7);
        montant.setText(montant.getText() + "7");
    }

    public void onClickBtn8(View view) {


        button8 = findViewById(R.id.button8);
        montant.setText(montant.getText() + "8");
    }

    public void onClickBtn9(View view) {


        button9 = findViewById(R.id.button9);
        montant.setText(montant.getText() + "9");
    }

    public void onClickBtn0(View view) {


        button0 = findViewById(R.id.button0);
        montant.setText(montant.getText() + "0");
    }

    public void onClickBtnPoint(View view) {


        buttonPoint = findViewById(R.id.buttonPoint);
        montant.setText(montant.getText() + ".");
    }

    public void onClickBtnC(View view) {

        buttonC = findViewById(R.id.buttonC);
        montant.setText("");
    }

    //Méthodes onClick sur les radioGroup rdgChoixAction et rdgChoixCompte

    public void onClickChoixAction(View view) {
    }

    public void onClickChoixCompte(View view) {
    }




    // Méthodes onClick qui permettent de finaliser la transaction et de montrer l'état des comptes.

    public void onClickEtat(View view) {

        buttonEtatComptes = findViewById(R.id.buttonEtatCompte);
    }

    public void onClickSoumettre(View view) {

        buttonSoumettre = findViewById(R.id.buttonSoumettre);
    }



}


