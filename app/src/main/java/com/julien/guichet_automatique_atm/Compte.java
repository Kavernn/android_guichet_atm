package com.julien.guichet_automatique_atm;

public class Compte {


    private int nip, numCompte;
   private  double soldeCompte;
  private Client le_client;

    public Compte(int numCompte, Client le_client) {
        this.numCompte = numCompte;
        this.le_client = le_client;
        this.soldeCompte =0;
    }

    public void retirerMontant(int montant){

    }

    public void deposerMontant(int montant){

    }


}
