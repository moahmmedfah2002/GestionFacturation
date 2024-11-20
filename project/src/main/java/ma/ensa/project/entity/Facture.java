package ma.ensa.project.entity;

import java.time.LocalDate;
import java.util.List;

public class Facture {
    private int id;
    private Long clientId;  // Id du client
    private double montant;
    private String statut;
    private LocalDate date;
    private double tva;
    private double rabais;
    private List<Produit> produits;  // Liste des produits associés à la facture

    // Constructeur
    public Facture(int id, Long clientId, double montant, String statut, LocalDate date, double tva, double rabais) {
        this.id = id;
        this.clientId = clientId;
        this.montant = montant;
        this.statut = statut;
        this.date = date;
        this.tva = tva;
        this.rabais = rabais;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public double getRabais() {
        return rabais;
    }

    public void setRabais(double rabais) {
        this.rabais = rabais;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    // Méthode pour calculer le montant total
    public double calculerMontantTotal() {
        double montantTotal = montant + (montant * tva) - rabais;
        return montantTotal;
    }
}
