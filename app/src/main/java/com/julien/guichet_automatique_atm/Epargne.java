package com.julien.guichet_automatique_atm;


public class Epargne extends Compte {

    private static double TAUXINTERET = 0.0125;


    public Epargne(int nip, String username, double soldeCpt) {
        super(nip, username, soldeCpt);
    }


    @Override
    public void depot(double amount){

        this.setSoldeCompte(this.getSoldeCompte() + amount);

    }


    @Override
    public void retrait(double amount){


        if(this.getSoldeCompte() - amount > 0 ){

            this.setSoldeCompte(this.getSoldeCompte() - amount);

        }

        else {

            System.out.println("Les fonds de votre compte sont insuffisants");

        }

    }

    public void paiementInterets(){

        this.setSoldeCompte(this.getSoldeCompte() * (1 + TAUXINTERET));

    }

    @Override
    public String toString(){


        String affichage = super.toString();
        affichage += " | Solde du Compte Epargne: " + this.getSoldeCompte() + " $ ";
        return affichage;

    }





}
