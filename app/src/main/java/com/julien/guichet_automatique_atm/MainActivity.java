        package com.julien.guichet_automatique_atm;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    static int increment =  0;

    public void onClickOK(View view) {
        // L'utilisateur n'a le droit qu'à trois essais :
        if (increment > 2) {
            Toast.makeText(this, "Vous avez eu trois chances, c'est bien assez !", 2).show();
            finish();
            System.exit(0);
        }

        // Initialiser la vue contenant le nom d'utilisateur et récupérer la chaine de caractère
        EditText nom = (EditText) findViewById(R.id.etxtNom);
        String le_nom = nom.getText().toString();

        // Initialiser la vue contenant le mot de passe et récupérer le nom d'utilisateur
        EditText mdp = (EditText) findViewById(R.id.etxtMdp);
        String le_mdp = mdp.getText().toString();

        // Si le mot de passe ou le nom d'utilisateur sont des chaines vides, alors on affiche un message d'erreur.
        if ((le_mdp.equals("")) || (le_nom.equals(""))) {

            Toast.makeText(this, "Vous devez rentrer un nom d'utilisateur et mot de passe", 2).show();
        }


//=============================================================================================VERSION AVEC ADMIN UNIQUE
        /*//Si le nom d'utilisateur et le mot de passe sont "admin", alors on va sur l'activité conversion.class à l'aide d'une intention
        // Sinon on demande à l'utilisateur de rentrer les bonnes informations.

        if ((le_mdp.equals("admin")) && (le_nom.equals("admin"))) {
            Intent intent = new Intent(this, GuichetActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Vous devez rentrer un nom d'utilisateur et un mot de passe corrects", 2).show();
        }*/

//=============================================================================================
        //Connection d'un client de Guichet 1 -

        Guichet Guichet1;
        Client le_client;

            if (Guichet1.validerUtilisateur(Integer.parseInt(le_mdp),le_nom )){
            le_client = Guichet1.trouverClient(Integer.parseInt(le_mdp),le_nom );

            // Redirection vers l'activité Guichet
            Intent intent = new Intent(this, GuichetActivity.class);
            startActivity(intent);
            }
            else {
                Toast.makeText(this, "Utilisateur ou mot de passe incorrect ", 2).show();
                }

        // Connection d'un administrateur de Guichet 1 :

        if (Guichet1.validerAdmin(Integer.parseInt(le_mdp),le_nom )) {
            le_client = Guichet1.trouverClient(Integer.parseInt(le_mdp),le_nom);

            //Redirection vers l'activité Admin
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
        }
            else {
            Toast.makeText(this, "Utilisateur ou mot de passe incorrect ", 2).show();
        }


//=============================================================================================
                //On incrémente le compteur statique
        increment = increment +1;


    }

    public void onClickQuitter(View view) {
        finish();
        System.exit(0);

    }
}