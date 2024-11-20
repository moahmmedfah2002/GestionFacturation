package ma.ensa.project.entity;
import java.util.Date;
import java.util.List;

public class Commande {
    private int id;
    private Date commandeDate;
    private int totalAmount;
    private Client client;
    private List<DetailCommande> detailCommande;

    public Commande(int id, Date commandeDate, int totalAmount, Client client, List<DetailCommande> detailCommande) {
        this.id = id;
        this.commandeDate = commandeDate;
        this.totalAmount = totalAmount;
        this.client = client;
        this.detailCommande = detailCommande;
    }
    public int getId() {
        return id;
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetailCommande> getDetailCommande() {
        return detailCommande;
    }

    public void setDetailCommande(List<DetailCommande> detailCommande) {
        this.detailCommande = detailCommande;
    }
}
