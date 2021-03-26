        package com.julien.guichet_automatique_atm;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.julien.guichet_automatique_atm.EXTRA_NUMBER";
    public static final String EXTRA_TEXT = "com.julien.guichet_automatique_atm.EXTRA_TEXT";
    Guichet guichet = new Guichet();
    static int increment = 0;
    private static final int REQUEST_CODE = 10;


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
            Toast.makeText(this, "Vous avez eu trois chances, c'est bien assez !", 2).show();
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

        /*if ((le_mdp.equals("julienvogler")) && (utilisateur.equals("12345"))) {
            Intent intent = new Intent(this, GuichetActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Vous devez rentrer un nom d'utilisateur et un mot de passe corrects", 2).show();
        }*/

//=============================================================================================
        // Connection d'un utilisateur :

        if (guichet.validerUtilisateur(nip,utilisateur )){
            // Redirection vers l'activité Guichet
            Intent intent_guichet = new Intent(this, GuichetActivity.class);

            // Faire passer nip et utilisateur dans GuichetActivity
            intent_guichet.putExtra(EXTRA_NUMBER, nip);
            intent_guichet.putExtra(EXTRA_TEXT, utilisateur);
            startActivity(intent_guichet);
            }

        // Connection d'un administrateur :
        else if (guichet.validerAdmin(nip,utilisateur )) {
            //Redirection vers l'activité Admin
            Intent intent_admin = new Intent(this, AdminActivity.class);

            // Faire passer nip et utilisateur dans l'intention
            intent_admin.putExtra(EXTRA_NUMBER, nip);
            intent_admin.putExtra(EXTRA_TEXT, utilisateur);
            startActivity(intent_admin);
        }
        else {
            Toast.makeText(this, "Utilisateur ou mot de passe incorrect ", 2).show();
        }

        //Incrémentation du compteur
        increment = increment +1;

    }

    /*//============================================code Udem
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                if ((data.getExtras() != null) && (data.getExtras().getString("returnKey1") != null))
                    Toast.makeText(this, data.getExtras().getString("returnKey1"),
                            Toast.LENGTH_SHORT).show();
            }
        }
    }

    //===========================================code udem*/


        public void onClickQuitter (View view){
            finish();
            System.exit(0);

        }
    }
