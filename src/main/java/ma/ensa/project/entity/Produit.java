package ma.ensa.project.entity;

public class Produit {
    private int id;
    private String nom;
    private int quantitedisponible;
    private double prix;

    // Constructeur sans paramètre
    public Produit() {
        // Ne fait rien
    }

    // Constructeur avec tous les champs
    public Produit(int id, String nom, int quantitedisponible, double prix) {
        this.id = id;
        this.nom = nom;
        this.quantitedisponible = quantitedisponible;
        this.prix = prix;
    }

    // Getters et setters
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

    public int getQuantiteDisponible() {
        return quantitedisponible;
    }

    public void setQuantiteDisponible(int quantite) {
        this.quantitedisponible = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
