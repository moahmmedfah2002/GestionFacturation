package ma.ensa.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
@Getter
@Setter
public class Paiement {
    private int id;
    private int factureId;
    private double montant;
    private Date datepaiement;
    private String modepaiement;
    private String statutpaiement;
    public Paiement(){}
    public Paiement(int id, int factureId, double montant, String modePaiement, Date datePaiement, String statutPaiement) {
        this.id = id;
        this.factureId = factureId;
        this.montant = montant;
        this.modepaiement = modepaiement;
        this.datepaiement = datepaiement;
        this.statutpaiement = statutpaiement;
    }



    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", factureId=" + factureId +
                ", montant=" + montant +
                ", modePaiement='" + modepaiement + '\'' +
                ", datePaiement=" + datepaiement +
                ", statutPaiement='" + statutpaiement + '\'' +
                '}';
    }
}
