package com.julien.guichet_automatique_atm;

public class GuichetAutomatique {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Guichet guichet1 = new Guichet();
        guichet1.addClient("Sijlamassi", "Hicham", "hichamsijlamassi", 12345);
        guichet1.addClient("Vogler", "Julien", "julienvogler", 12345);
        guichet1.addClient("Pinard", "Vincent", "pinardvincent", 12345);
        guichet1.addAdmin("hicham", "admin");
        //guichet1.afficherClients();


        //Ajouter compte cheque
        guichet1.addCompteCheque("hichamsijlamassi", 12345);
        guichet1.addCompteCheque("julienvogler", 12345);
        guichet1.addCompteCheque("pinardvincent", 12345);

        //Ajouter compte Epargne
        guichet1.addCompteEpargne("hichamsijlamassi", 12345);
        guichet1.addCompteEpargne("julienvogler", 12345);
        guichet1.addCompteEpargne("pinardvincent", 12345);


        //Affichage de tout
        guichet1.afficherUnClient(12345, "hichamsijlamassi");
        guichet1.afficherUnClient(12345, "julienvogler");

        guichet1.depotCheque(12345, "julienvogler", 2000);
        guichet1.afficherUnClient(12345, "julienvogler");


        //afficher admins
        guichet1.afficherAdmins();

    }

}
