package ma.ensa.project.entity;

public class DetaileCommande {

    private int id;                    // Identifiant unique du détail de commande
    private Commande commande;         // Commande associée
    private Produit produit;           // Produit associé à ce détail
    private int quantite;              // Quantité commandée
    private double prixUnitaire;       // Prix unitaire du produit
    private double total;              // Montant total pour ce produit (quantité * prix unitaire)

    // Constructeur
    public DetaileCommande(int id, Commande commande, Produit produit, int quantite, double prixUnitaire) {
        this.id = id;
        this.commande = commande;
        this.produit = produit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.total = quantite * prixUnitaire;  // Calcul du total
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
        this.total = quantite * this.prixUnitaire;  // Recalcul du total si la quantité change
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
        this.total = this.quantite * prixUnitaire;  // Recalcul du total si le prix unitaire change
    }

    public double getTotal() {
        return total;
    }

    // Méthode pour afficher les informations du détail de la commande
    @Override
    public String toString() {
        return "DetaileCommande{" +
                "id=" + id +
                ", commande=" + commande.getId() +
                ", produit=" + produit.getNom() +
                ", quantite=" + quantite +
                ", prixUnitaire=" + prixUnitaire +
                ", total=" + total +
                '}';
    }
}
