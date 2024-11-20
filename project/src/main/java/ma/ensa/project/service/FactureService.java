package ma.ensa.project.service;

import ma.ensa.project.entity.Client;
import ma.ensa.project.entity.Facture;
import ma.ensa.project.entity.Produit;

import java.util.ArrayList;
import java.util.List;

public class FactureService {

    // Liste des factures
    private List<Facture> factures;

    // Constructeur
    public FactureService() {
        this.factures = new ArrayList<>();
    }

    // Méthode pour créer une facture
    public Facture creerFacture(Client client, List<Produit> produits, double tva, double rabais) {
        int id = factures.size() + 1; // Génération d'un ID unique
        double montantBrut = calculerMontantBrut(produits);
        // Créer la facture avec TVA et rabais
        Facture nouvelleFacture = new Facture(id, client.getId(), montantBrut, "En attente", java.time.LocalDate.now(), tva, rabais);
        factures.add(nouvelleFacture);
        System.out.println("Facture créée avec succès : " + nouvelleFacture.getId());
        return nouvelleFacture;
    }

    // Méthode pour mettre à jour une facture
    public Facture mettreAJourFacture(int id, List<Produit> nouveauxProduits, double tva, double rabais) {
        for (Facture facture : factures) {
            if (facture.getId() == id) {
                double montantBrut = calculerMontantBrut(nouveauxProduits);
                // Mettre à jour la facture
                facture.setProduits(nouveauxProduits);
                facture.setMontant(montantBrut);
                facture.setTva(tva);
                facture.setRabais(rabais);
                System.out.println("Facture mise à jour avec succès : " + facture.getId());
                return facture;
            }
        }
        System.out.println("Facture non trouvée pour l'ID : " + id);
        return null;
    }

    // Méthode pour supprimer une facture
    public boolean supprimerFacture(int id) {
        for (Facture facture : factures) {
            if (facture.getId() == id) {
                factures.remove(facture);
                System.out.println("Facture supprimée avec succès : " + id);
                return true;
            }
        }
        System.out.println("Facture non trouvée pour l'ID : " + id);
        return false;
    }

    // Méthode pour afficher toutes les factures
    public void afficherFactures() {
        if (factures.isEmpty()) {
            System.out.println("Aucune facture n'a été créée.");
        } else {
            for (Facture facture : factures) {
                System.out.println("Facture ID: " + facture.getId() +
                        ", Total: " + facture.calculerMontantTotal() +
                        ", Statut: " + facture.getStatut());
            }
        }
    }

    // Méthode utilitaire pour calculer le montant brut (sans TVA ni rabais)
    private double calculerMontantBrut(List<Produit> produits) {
        double total = 0.0;
        for (Produit produit : produits) {
            total += produit.getPrix();
        }
        return total;
    }
}
