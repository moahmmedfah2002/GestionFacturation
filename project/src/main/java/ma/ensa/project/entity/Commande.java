package ma.ensa.project.entity;
import java.sql.Date;
import java.util.List;

public class Commande {
    private int id;
    private Date commandeDate;
    private float totalAmount;
    private int client;

    private List<Integer> detailCommande;
    private int idUser ;
    private int idPaiement;
    private int statusPaiement;


    public Commande() {}
    public Commande(Date commandeDate, float totalAmount ) {


        this.commandeDate = commandeDate;
        this.totalAmount = totalAmount;
    }

    public Commande(int id, Date commandeDate, float totalAmount, int client, List<Integer> detailCommande ,int idPaiement ) {
        if(idPaiement!=0){
            this.statusPaiement=1;
        }else{
            this.statusPaiement=0;
        }
        this.id = id;
        this.commandeDate = commandeDate;
        this.totalAmount = totalAmount;
        this.client = client;
        this.detailCommande = detailCommande;
    }
    //constructeur sans id pour auto increment
    public Commande(Date commandeDate, float totalAmount, int client,int idPaiement ) {
        if(idPaiement!=0){
            this.statusPaiement=1;
        }else{
            this.statusPaiement=0;
        }

        this.commandeDate = commandeDate;
        this.totalAmount = totalAmount;
        this.client = client;

    }
    public int getId() {
        return id;
    }
    public int getIdUser(){ return idUser;}
    public int getIdPaiement() {
        return idPaiement;
    }
    public int getStatusPaiement() {
        return statusPaiement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCommandeDate() {
        return commandeDate;
    }

    public void setCommandeDate(Date commandeDate) {
        this.commandeDate = commandeDate;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public List<Integer> getDetailCommande() {
        return detailCommande;
    }

    public void setDetailCommande(List<Integer> detailCommande) {
        this.detailCommande = detailCommande;
    }
}
