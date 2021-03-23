package com.julien.guichet_automatique_atm;

/**
 *
 * @author user
 */
abstract public class Compte {

    private int numeroNIP;
    private String username;
    private int numeroCompte;
    private double soldeCompte;
    private static int autoNumeroCompte = 10000;

    public Compte (int nip, String username, double soldeCpt){


        this.numeroNIP = nip;
        this.username = username;
        this.numeroCompte = ++ autoNumeroCompte;
        this.soldeCompte = soldeCpt;

    }


    //

    public int getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(int numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }


    public double getSoldeCompte() {
        return this.soldeCompte;
    }


    public String getUsername() {
        return this.username;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public abstract void retrait(double amount);

    public abstract void depot(double amount);

    public static int getAutoNumeroCompte() {
        return autoNumeroCompte;
    }

    @Override
    public String toString(){

        String affichage = "Compte no: " + this.numeroCompte + " ******************** \n";
        affichage += " Username: " + this.username;
        return affichage;

    }





}
