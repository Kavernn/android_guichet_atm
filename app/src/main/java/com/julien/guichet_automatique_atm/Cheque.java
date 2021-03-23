package com.julien.guichet_automatique_atm;


public class Cheque extends Compte {

    public Cheque(int nip, String username, double soldeCpt) {
        super(nip, username, soldeCpt);
    }

    @Override
    public void depot(double amount) {

        this.setSoldeCompte(this.getSoldeCompte() + amount);

    }


    @Override
    public void retrait(double amount) {

        this.setSoldeCompte(this.getSoldeCompte() - amount);

    }

    @Override
    public String toString() {


        String affichage = super.toString();
        affichage += " | Solde du Compte Cheque: " + this.getSoldeCompte() + " $ ";
        return affichage;

    }
}