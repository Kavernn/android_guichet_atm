package com.julien.guichet_automatique_atm;

public class Epargne extends Compte  {

    final double taux = 2;

    public Epargne(int numCompte, Client le_client) {
        super(numCompte, le_client);
    }

    public void payerInterets(Client le_client){


    }

}
