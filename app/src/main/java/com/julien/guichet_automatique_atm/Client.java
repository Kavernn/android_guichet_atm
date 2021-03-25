package com.julien.guichet_automatique_atm;



/**
 *
 * @author user
 */
public class Client {

    private String name;
    private String prenom;
    private String username;
    public String user_type = "client";
    private int numeroNIP;

    //constructeur

    public Client(String name, String prenom, String username, int numeroNIP) {
        this.name = name;
        this.prenom = prenom;
        this.username = username;
        this.numeroNIP = numeroNIP;
    }


    //constructeur admin
    public Client(String username, String user_type) {

        this.user_type = user_type;
        if(this.user_type.toUpperCase().equals("ADMIN")){

            //this.username = username + "_ADMIN";
            this.username = username;
            this.name = null;
            this.prenom = null;
            this.numeroNIP = 12345;

        }

        else {

            System.out.println("you just called the admin constructor which take 2 parameters. user_type should be admin in order to create and ADMIN");


        }


    }



    //accesseur

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    // Ajout de getUserType()


    public String getUser_type() {
        return user_type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumeroNIP() {
        return numeroNIP;
    }

    public void setNumeroNIP(int numeroNIP) {
        this.numeroNIP = numeroNIP;
    }

    @Override
    public String toString(){

        return "Type d'utilisateur: " + user_type + "\nNom d'utilisateur: " + this.username + " | NIP: " + " ************** " + "\nNom: " + this.name + " " + this.prenom + "\n";

    }


    public boolean changeNIP (int nip){

        if (this.getNumeroNIP() == nip){

            this.setNumeroNIP(nip);
            return true;
        }

        else {

            return false;

        }

    }

}
