        package com.julien.guichet_automatique_atm;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    public static final String extra_nip = "extra_nip";
    public static final String extra_utilisateur = "extra_utilisateur";
    Guichet guichet = new Guichet();

    static int increment =  0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guichet.addClient("Sijlamassi", "Hicham", "hichamsijlamassi", 12345);
        guichet.addClient("Vogler", "Julien", "julienvogler", 12345);
        guichet.addClient("Pinard", "Vincent", "pinardvincent", 12345);
        guichet.addAdmin("Hicham", "admin");




        }



    public void onClickOK(View view) {
        // L'utilisateur n'a le droit qu'à trois essais :
        if (increment > 2) {
            Toast.makeText(this, "Vous avez eu trois chances, c'est bien assez !", Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
        }

        // Initialiser la vue contenant le nom d'utilisateur et récupérer la chaine de caractère
        EditText nom = (EditText) findViewById(R.id.etxtNom);
        String utilisateur = nom.getText().toString();

        // Initialiser la vue contenant le mot de passe et récupérer le nom d'utilisateur
        EditText mdp = (EditText) findViewById(R.id.etxtMdp);
        String le_mdp = mdp.getText().toString();
        int nip = Integer.parseInt(le_mdp);


//=============================================================================================VERSION AVEC ADMIN UNIQUE
        //Si le nom d'utilisateur et le mot de passe sont "admin", alors on va sur l'activité conversion.class à l'aide d'une intention
        // Sinon on demande à l'utilisateur de rentrer les bonnes informations.

       /* if ((le_mdp.equals("admin")) && (utilisateur.equals("admin"))) {
            Intent intent = new Intent(this, GuichetActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Vous devez rentrer un nom d'utilisateur et un mot de passe corrects", 2).show();
        }*/

//=============================================================================================
        // Connection d'un utilisateur :

        if (guichet.validerUtilisateur(nip,utilisateur )){
            // Redirection vers l'activité Guichet
            Intent intent_guichet = new Intent(this, GuichetActivity.class);
            startActivity(intent_guichet);
            // Faire passer nip et utilisateur dans GuichetActivity
           // intent_guichet.putExtra(extra_utilisateur, utilisateur);
           // intent_guichet.putExtra(extra_nip, nip);

            }

        // Connection d'un administrateur :
        else if (guichet.validerAdmin(nip,utilisateur )) {
            //Redirection vers l'activité Admin
            Intent intent_admin = new Intent(this, AdminActivity.class);
            startActivity(intent_admin);
            // Faire passer nip et utilisateur dans l'intention
            intent_admin.putExtra(extra_nip, nip);
            intent_admin.putExtra(extra_utilisateur, utilisateur);
        }
        else {
            Toast.makeText(this, "Utilisateur ou mot de passe incorrect ", Toast.LENGTH_SHORT).show();
        }

        //Incrémentation du compteur
        increment = increment +1;

    }

    public void onClickQuitter(View view) {
        finish();
        System.exit(0);

    }
}