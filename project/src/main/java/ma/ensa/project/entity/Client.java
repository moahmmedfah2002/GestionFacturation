package ma.ensa.project.entity;


import lombok.Data;

import java.util.List;
@Data
public class Client {
    private int id;
    private String nom;
    private String email;
    private String telephone;
    private String adresse;
    private List<Commande> commandes;
    private int userId;

    // Constructeurs
    public Client() {}

    public Client(int id, String nom, String email, String telephone, String adresse,int userId) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.userId = userId;
    }
    //constructeur sans id pour auto increment
    public Client(String nom, String email, String telephone, String adresse,int userId) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.userId = userId;
    }





}
