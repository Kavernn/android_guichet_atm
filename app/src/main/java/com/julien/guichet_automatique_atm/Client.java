package com.julien.guichet_automatique_atm;

public class Client {

    private String nom, prenom, username, nip;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUsername() {
        return username;
    }

    public String getNip() {
        return nip;
    }

}
