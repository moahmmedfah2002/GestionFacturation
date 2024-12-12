package ma.ensa.project.entity;

import lombok.Data;

@Data
public class DetaileCommande {

    private int id;                    // Identifiant unique du détail de commande
    private int idcommande;         // Commande associée
    private int idProduit;           // Produit associé à ce détail
    private int quantite;              // Quantité commandée

    // Constructeur
    public DetaileCommande() {

    }
    public DetaileCommande(int id, int idcommande, int idProduit, int quantite) {
        this.id = id;
        this.idcommande = idcommande;
        this.idProduit = idProduit;
        this.quantite = quantite;

    }
    public DetaileCommande( int idcommande, int idProduit, int quantite) {
        this.idcommande = idcommande;
        this.idProduit = idProduit;
        this.quantite = quantite;

    }



}
