package ma.ensa.project.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String nomUtilisateur;
    private String motDePasse;
    private String role;
    public User() {
    }
    public User(int id, String nomUtilisateur, String motDePasse, String typeUser) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.role = typeUser;

    }


}
