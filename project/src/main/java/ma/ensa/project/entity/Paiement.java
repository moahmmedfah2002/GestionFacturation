package ma.ensa.project.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Paiement {
    private int id;
    private int factureId;
    private double montant;
    private LocalDate datepaiement;
    private String modepaiement;
    private String statutpaiement;
    public Paiement(){}
    public Paiement(int id, int factureId, double montant, String modePaiement, LocalDate datePaiement, String statutPaiement) {
        this.id = id;
        this.factureId = factureId;
        this.montant = montant;
        this.modepaiement = modepaiement;
        this.datepaiement = datepaiement;
        this.statutpaiement = statutpaiement;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactureId() {
        return factureId;
    }

    public void setFactureId(int factureId) {
        this.factureId = factureId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getModepaiement() {
        return modepaiement;
    }

    public void setModepaiement(String modePaiement) {
        this.modepaiement = modepaiement;
    }

    public Date getDatePaiement() {
        return datepaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datepaiement = datepaiement;
    }

    public String getStatutPaiement() {
        return statutpaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutpaiement = statutpaiement;
    }

    public boolean validationPaiement(){
        if (montant <=0){
            System.out.println("lemontant du paiement doit etre superieur a 0");
            return false;
        }
        if (modepaiement == null ){
            System.out.println("le mode de paiement est invalide");
            return false;
        }
        if (datepaiement == null || datepaiement.isAfter(LocalDate.now())){
            System.out.println("la date de paiement est invalide");
            return  false;

        }
        if (statutpaiement == null || datepaiement.isAfter(LocalDate.now())){
            System.out.println("le status du paiement est invalide");
            return false;

        }
        return true;

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
