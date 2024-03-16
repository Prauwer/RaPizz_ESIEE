package com.example.rapizzapp.entities;

import java.lang.invoke.VarHandle;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Commande {
    private int idCommande;
    private String adresseCommande;
    private LocalDateTime dateCommande;
    private LocalDateTime dateLivraison;
    private Client client;
    private Livreur livreur;
    private Vehicule vehicule;

    private HashMap<Pizza,Taille> pizzas;

    private double montant = 0.0; // Valeur par défaut

    // Constructeur
    public Commande() {
        this.idCommande = -1;
        this.adresseCommande = "";
        this.dateCommande = LocalDateTime.now();
        this.dateLivraison = LocalDateTime.now();
        this.client = new Client();
        this.livreur = new Livreur();
        this.vehicule = new Vehicule();
        this.pizzas =new HashMap<Pizza,Taille>();
    }

    public Commande(int idCommande, String adresseCommande, LocalDateTime dateCommande, LocalDateTime dateLivraison, Client cLient, Livreur livreur, Vehicule vehicule,HashMap<Pizza,Taille> commande) {
        this.idCommande = idCommande;
        this.adresseCommande = adresseCommande;
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.client = client;
        this.livreur = livreur;
        this.vehicule = vehicule;
        this.pizzas = commande;
    }

    // Getters et setters
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getAdresseCommande() {
        return adresseCommande;
    }

    public void setAdresseCommande(String adresseCommande) {
        this.adresseCommande = adresseCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public LocalDateTime getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDateTime dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public HashMap<Pizza,Taille> getPizzas(){ return this.pizzas; }

    public void setPizzas(HashMap<Pizza,Taille> pizzas){ this.pizzas = pizzas; }
}
