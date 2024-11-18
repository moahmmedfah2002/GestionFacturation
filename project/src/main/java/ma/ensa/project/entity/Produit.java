package ma.ensa.project.entity;

public class Produit {
    private int id;
    private String nom;
    private double prix;
    private int quantiteDisponible;

    public Produit(int id, String nom, double prix, int quantiteDisponible) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantiteDisponible = quantiteDisponible;
    }

    public boolean verifierDisponibilite(int quantiteDemandee) {
        return quantiteDemandee <= quantiteDisponible;
    }

    public void reduireStock(int quantiteVendue) {
        if (quantiteVendue <= quantiteDisponible) {
            quantiteDisponible -= quantiteVendue;
        } else {
            throw new IllegalArgumentException("Quantité demandée supérieure au stock disponible !");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }
}
