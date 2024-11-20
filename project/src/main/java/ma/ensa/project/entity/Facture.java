package ma.ensa.project.entity;

import java.util.List;
import java.time.LocalDate;

public class Facture {

    // Attributs
    private int id;
    private int clientId;
    private double montant;
    private String statut;
    private LocalDate datecreation;
    private double tva;
    private double rabais;

    // Constructeur sans paramètres
    public Facture() {}

    // Constructeur avec paramètres
    public Facture(int id, int clientId, double montant, String statut, LocalDate datecreation, double tva, double rabais) {
        this.id = id;
        this.clientId = clientId;
        this.montant = montant;
        this.statut = statut;
        this.datecreation = datecreation;
        this.tva = tva;
        this.rabais = rabais;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDate getDatecreation() { return datecreation; }
    public void setDatecreation(LocalDate datecreation) { this.datecreation = datecreation; }

    public double getTva() { return tva; }
    public void setTva(double tva) { this.tva = tva; }

    public double getRabais() { return rabais; }
    public void setRabais(double rabais) { this.rabais = rabais; }

    // Méthode pour calculer le montant total (TVA et rabais inclus)
    public double calculerMontantTotal() {
        // Calcul de la TVA
        double montantTVA = montant * (tva / 100);

        // Calcul du rabais
        double montantRabais = montant * (rabais / 100);

        // Montant total = montant de base + TVA - Rabais
        return montant + montantTVA - montantRabais;
    }

    // Validation de la facture
    public boolean validerFacture() {
        // Validation des données de la facture
        if (clientId <= 0) {
            System.out.println("Erreur : L'ID du client doit être supérieur à 0.");
            return false;
        }
        if (montant <= 0) {
            System.out.println("Erreur : Le montant doit être supérieur à 0.");
            return false;
        }
        if (tva < 0) {
            System.out.println("Erreur : La TVA doit être positive ou égale à 0.");
            return false;
        }
        if (rabais < 0) {
            System.out.println("Erreur : Le rabais doit être positif ou égal à 0.");
            return false;
        }
        if (datecreation == null || datecreation.isAfter(LocalDate.now())) {
            System.out.println("Erreur : La date de création est invalide. Elle ne peut pas être dans le futur.");
            return false;
        }
        if (!statutValide(statut)) {
            System.out.println("Erreur : Le statut de la facture est invalide.");
            return false;
        }
        return true;
    }

    // Méthode utilitaire pour vérifier la validité du statut
    private boolean statutValide(String statut) {
        List<String> statutsValides = List.of("En attente", "Payée", "Impayée");
        return statutsValides.contains(statut);
    }

    // Méthode pour afficher les informations de la facture
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", montant=" + montant +
                ", statut='" + statut + '\'' +
                ", datecreation=" + datecreation +
                ", tva=" + tva +
                ", rabais=" + rabais +
                ", montantTotal=" + calculerMontantTotal() +
                '}';
    }

    // Méthode pour mettre à jour le statut de la facture
    public void mettreAJourStatut(String nouveauStatut) {
        this.statut = nouveauStatut;
    }

    public void setProduits(List<Produit> nouveauxProduits) {
    }
}
