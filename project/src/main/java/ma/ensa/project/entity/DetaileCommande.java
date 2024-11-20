package ma.ensa.project.entity;

public class DetailCommande {
    private int detailId;
    private int quantity;
    private int unitPrix;
    private int totalPrix;
    private Produit produits; // Association avec une classe Produit
    
    public DetailCommande(int detailId, int quantity, int unitPrix, Produit produits) {
        this.detailId = detailId;
        this.quantity = quantity;
        this.unitPrix = unitPrix;
        this.produits = produits;
        this.totalPrix = calculerTotalPrix(); // Calcul automatique du prix total
    }
    
    public int calculerTotalPrix() {
        return quantity * unitPrix;
    }
    
    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrix = calculerTotalPrix(); // Mettre à jour le totalPrix
    }

    public int getUnitPrix() {
        return unitPrix;
    }

    public void setUnitPrix(int unitPrix) {
        this.unitPrix = unitPrix;
        this.totalPrix = calculerTotalPrix(); // Mettre à jour le totalPrix
    }

    public int getTotalPrix() {
        return totalPrix;
    }

    public Produit getProduits() {
        return produits;
    }

    public void setProduits(Produit produits) {
        this.produits = produits;
    }
}
