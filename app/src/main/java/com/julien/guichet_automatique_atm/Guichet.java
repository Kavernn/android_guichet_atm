package com.julien.guichet_automatique_atm;

import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Guichet {

    private ArrayList <Client> clients;
    private ArrayList <Compte> compteCheques;
    private ArrayList <Compte> compteEpargnes;




    public Guichet() {
        this.clients = new ArrayList <Client>();
        this.compteCheques = new ArrayList <Compte>();
        this.compteEpargnes = new ArrayList <Compte>();
    }


    public void addClient(String name, String prenom, String username, int nip){

        Client un_client = new Client (name, prenom, username, nip);

        if(!this.validerUtilisateur(nip, username)){

            clients.add(un_client);
        }

        else

            System.out.println("Le client existe deja.");



    }



    public void addAdmin(String username, String user_type){

        Client admin = new Client (username, user_type);

        if(!this.validerUtilisateur(admin.getNumeroNIP(), username)){

            clients.add(admin);
        }

        else

            System.out.println("Cet Admin existe deja.");



    }


    public void addCompteCheque(String username, int nip){


        if(this.validerUtilisateur(nip, username)){

            Compte compteCheque = new Cheque (nip, username, 0);
            compteCheques.add(compteCheque);
        }

        else {
            // System.out.println("La combinaison Username / Password n'existe pas");
        }

    }


    public void addCompteCheque(Client un_client){


        if(this.validerUtilisateur(un_client.getNumeroNIP(), un_client.getUsername())){

            Compte compteCheque = new Cheque (un_client.getNumeroNIP(), un_client.getUsername(), 0);
            compteCheques.add(compteCheque);
        }

        else {
            //System.out.println("La combinaison Username / Password n'existe pas");
        }

    }




    public void addCompteEpargne(String username, int nip){


        if(this.validerUtilisateur(nip, username)){

            Compte compteEpargne = new Epargne (nip, username, 0);
            compteEpargnes.add(compteEpargne);
        }

        else {
            //System.out.println("La combinaison Username / Password n'existe pas");
        }

    }


    public void addCompteEpargne(Client un_client){


        if(this.validerUtilisateur(un_client.getNumeroNIP(), un_client.getUsername())){

            Compte compteEpargne = new Epargne (un_client.getNumeroNIP(), un_client.getUsername(), 0);
            compteEpargnes.add(compteEpargne);
        }

        else {
            //System.out.println("La combinaison Username / Password n'existe pas");
        }

    }


    public boolean validerUtilisateur(int nip, String username){


        boolean isClient = false;

        for (Client c: clients){

            if ((c.getUsername().equals(username) && c.getNumeroNIP() == nip) &&
            !(c.getUser_type().equals("ADMIN")))
            {

                return true;

            }

        }

        //System.out.println(" La combinaison nom utilisateur / NIP n'existe pas");
        return isClient;

    }


    // Méthode Valider Admin

    public boolean validerAdmin(int nip, String username){


        boolean isClient = false;

        for (Client c: clients){

            if ((c.getUsername().equals(username) && c.getNumeroNIP() == nip)
                && (c.getUser_type().equals("ADMIN"))){
                return true;
            }
        }

        //System.out.println(" La combinaison nom utilisateur / NIP n'existe pas");
        return isClient;

    }









    public double retraitCheque(int nip, String username, double montant){

            Compte compteCheque = trouverCompteCheque(nip, username);

            if (compteCheque != null){ // Verifie que compteCheque exsite dans compteCheques

                if (compteCheque.getSoldeCompte() > montant){ // Verifie si les fonds sont suffisants

                    compteCheque.retrait(montant);
                    double solde = compteCheque.getSoldeCompte();
                    return solde;

                }

                else {


                    return -1;

                }

            }


        return -1;

    }



    public double retraitEpargne(int nip, String username, double montant){

            Compte compteEpargne = trouverCompteEpargne(nip, username);

            if (compteEpargne != null){ // Verifie que compteCheque exsite dans compteCheques

                if (compteEpargne.getSoldeCompte() > montant){ // Verifie si les fonds sont suffisants

                    compteEpargne.retrait(montant);
                    double solde = compteEpargne.getSoldeCompte();
                    return solde;
                }
                else {

                    return -1;
                }
            }
            return -1;
    }


    public double depotCheque(int nip, String username, double montant){

            Compte cheque = trouverCompteCheque(nip, username);

            if (cheque != null) {

                cheque.depot(montant);
                return cheque.getSoldeCompte();
            }


        return -1;

    }


    public double depotEpargne(int nip, String username, double montant){


            Compte epargne = trouverCompteEpargne(nip, username);

            if(epargne != null){
                epargne.depot(montant);
                return epargne.getSoldeCompte();
            }



        return -1;


    }


    public void afficherClients(){

        for (Client c: clients){

            System.out.println(c);
        }


    }


    public void afficherUnClient(int nip, String username){


        // afficher info client
        Client un_client = trouverClient(nip, username);
        System.out.println(un_client);
        Compte cheque = trouverCompteCheque(nip, username);
        System.out.println(cheque);
        Compte epargne = trouverCompteEpargne(nip, username);
        System.out.println(epargne);


        //Afficher info Compte Cheque

    }


    public void afficherAdmins(){

        for (Client c: clients){

            if (c.user_type.equals("admin"))
                System.out.println(c);
        }

    }







    public Compte trouverCompteCheque(int nip, String username){

        //Compte cheque;
        for (Compte chq: compteCheques){

            if (chq.getUsername().equals(username) && chq.getNumeroNIP() == nip){

                //cheque = compteCheques.get(chq);
                int idx = compteCheques.indexOf(chq);
                return compteCheques.get(idx);


            }

        }

        System.out.println(" Le compte cheque rechercher n'existe pas");
        return null;

    }



    public Compte trouverCompteEpargne(int nip, String username){

        //Compte epargne;
        for (Compte epr: compteEpargnes){

            if (epr.getUsername().equals(username) && epr.getNumeroNIP() == nip){

                //cheque = compteCheques.get(chq);
                int idx = compteEpargnes.indexOf(epr);
                return compteEpargnes.get(idx);


            }

        }

        System.out.println(" Le compte epargne recherche n'existe pas");
        return null;

    }


    public Client trouverClient(int nip, String username){

        Client un_client;
        for (Client c: clients){
            if (c.getNumeroNIP() == nip && c.getUsername().equals(username)){
                int idx = clients.indexOf(c);
                return clients.get(idx);
            }

        }

        return null;

    }


}
