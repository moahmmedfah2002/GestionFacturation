package ma.ensa.project.entity;

import java.sql.Date;

public class Facture {
    private int id;
    private int clientId;
    private double montant;
    private boolean statut;
    private Date date;
    private double tax;
    private Paiement paiements;
    private Commande commande;

    // Constructeur
    public Facture(int id, int clientId, double montant, boolean statut, Date date, double tax, Paiement paiements) {
        this.id = id;
        this.clientId = clientId;
        this.montant = montant;
        this.statut = statut;
        this.date = date;
        this.tax = tax;
        this.paiements = paiements;
    }

    public Facture() {

    }

    public Facture(String number, String clientA, String date, double v, double v1, String payée) {
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Paiement getPaiements() {
        return paiements;
    }

    public void setPaiements(Paiement paiements) {
        this.paiements = paiements;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
