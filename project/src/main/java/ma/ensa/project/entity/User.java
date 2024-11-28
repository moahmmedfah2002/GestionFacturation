package ma.ensa.project.entity;

public class User {
    private int id;
    private String nomUtilisateur;
    private String motDePasse;
    private Role typeUser;
    public User() {
    }
    public User(int id, String nomUtilisateur, String motDePasse, Role typeUser) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.typeUser = typeUser;
    }
    public void seConnecter() {
        System.out.println(nomUtilisateur + " s'est connecté.");
    }
    public void seDeconnecter() {
        System.out.println(nomUtilisateur + " s'est déconnecté.");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public Role getTypeUser() {
        return typeUser;
    }
    public void setTypeUser(Role typeUser) {
        this.typeUser = typeUser;
    }
}
