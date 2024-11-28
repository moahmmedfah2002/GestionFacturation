package ma.ensa.project.entity;

import lombok.Data;

import java.util.List;

@Data
public class DetaileCommande {

    private int id;                    // Identifiant unique du détail de commande
    private int idcommande;         // Commande associée
    private List<Produit> produit;           // Produit associé à ce détail
    private int quantite;              // Quantité commandée

    // Constructeur
    public DetaileCommande() {

    }
    public DetaileCommande(int id, int idcommande, List<Produit> produit, int quantite, double prixUnitaire) {
        this.id = id;
        this.idcommande = idcommande;
        this.produit = produit;
        this.quantite = quantite;

    }



}
