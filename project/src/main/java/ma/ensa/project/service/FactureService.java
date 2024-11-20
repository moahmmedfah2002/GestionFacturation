package ma.ensa.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FactureService {
    private List<Facture> factures; // Simule une base de données pour les factures

    public FactureService() {
        this.factures = new ArrayList<>();
    }

    // Méthode pour créer une facture
    public Facture creerFacture(int clientId, double montant, double tva, double rabais) {
        Facture nouvelleFacture = new Facture();
        nouvelleFacture.setId(factures.size() + 1); // Génération d'un ID unique
        nouvelleFacture.setClientId(clientId);
        nouvelleFacture.setMontant(montant);
        nouvelleFacture.setTva(tva);
        nouvelleFacture.setRabais(rabais);
        nouvelleFacture.setStatut("En attente");
        nouvelleFacture.setDatecreation(LocalDate.now());

        // Validation de la facture avant ajout
        if (!nouvelleFacture.validerFacture()) {
            System.out.println("Erreur : Facture invalide. Création annulée.");
            return null;
        }

        // Ajout à la liste des factures
        factures.add(nouvelleFacture);
        System.out.println("Facture créée avec succès : " + nouvelleFacture);
        return nouvelleFacture;
    }

    // Méthode pour mettre à jour une facture
    public Facture mettreAJourFacture(int id, Double nouveauMontant, Double nouvelleTva, Double nouveauRabais, String nouveauStatut) {
        for (Facture facture : factures) {
            if (facture.getId() == id) {
                if (nouveauMontant != null) facture.setMontant(nouveauMontant);
                if (nouvelleTva != null) facture.setTva(nouvelleTva);
                if (nouveauRabais != null) facture.setRabais(nouveauRabais);
                if (nouveauStatut != null) facture.setStatut(nouveauStatut);

                // Validation de la facture après modification
                if (!facture.validerFacture()) {
                    System.out.println("Erreur : Facture invalide après mise à jour.");
                    return null;
                }

                System.out.println("Facture mise à jour avec succès : " + facture);
                return facture;
            }
        }
        System.out.println("Erreur : Facture avec ID " + id + " non trouvée.");
        return null;
    }

    // Méthode pour supprimer une facture
    public boolean supprimerFacture(int id) {
        for (Facture facture : factures) {
            if (facture.getId() == id) {
                factures.remove(facture);
                System.out.println("Facture supprimée avec succès : " + facture);
                return true;
            }
        }
        System.out.println("Erreur : Facture avec ID " + id + " non trouvée.");
        return false;
    }

    // Méthode pour afficher toutes les factures
    public List<Facture> getToutesLesFactures() {
        return factures;
    }

    // Méthode pour rechercher une facture par ID
    public Facture rechercherFactureParId(int id) {
        for (Facture facture : factures) {
            if (facture.getId() == id) {
                return facture;
            }
        }
        System.out.println("Erreur : Facture avec ID " + id + " non trouvée.");
        return null;
    }
}