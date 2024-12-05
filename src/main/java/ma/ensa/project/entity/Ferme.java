package ma.ensa.project.entity;



public class Ferme {
    private int id;
    private String nom;
    private String localisation;
    private double taille;
    private String responsable;

    // Constructeur par défaut
    public Ferme() {}

    // Constructeur avec paramètres
    public Ferme(int id, String nom, String localisation, double taille, String responsable) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.taille = taille;
        this.responsable = responsable;
    }

    // Getters et Setters
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

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Ferme{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", localisation='" + localisation + '\'' +
                ", taille=" + taille +
                ", responsable='" + responsable + '\'' +
                '}';
    }
}

