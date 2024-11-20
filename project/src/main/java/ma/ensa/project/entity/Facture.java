package ma.ensa.project.entity;



import java.time.LocalDate;

public class Facture {
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    private int id;

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getClientId() {
        return clientId;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    private int clientId;

    public double getMontant() {
        return montant;
    }

    private double montant;

    public String getStatut() {
        return statut;
    }

    private String statut;

    public LocalDate getDatecreation() {
        return datecreation;
    }

    private LocalDate datecreation;
    public Facture (){

    }

    public double getTva() {
        return tva;
    }

    public double getRabais() {
        return rabais;
    }

    public void setRabais(double rabais) {
        this.rabais = rabais;
    }

    private double rabais;

    public void setTva(double tva) {
        this.tva = tva;
    }

    private double tva;

    public  Facture(int id, int clientId, double montant, String status, LocalDate datecreation){
        this.id=id;
        this.clientId= clientId;
        this.montant= montant;
        this.statut= status;
        this.datecreation= datecreation;
        this.tva=tva;
        this.rabais=rabais;;
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //
    public double calculerMontantTotal(){
        double montantTVA = montant * (tva / 100);
        double monatantRabais = montant * (rabais  / 100);
        return montant + montantTVA - monatantRabais;

    }
    public boolean validerFacture(){
        if (clientId <= 0){
            System.out.println("ID client invalid");
            return false;

        }
        if (montant <= 0){
            System.out.println("le montant doit etre superieur a 0");
            return false;

        }
        if (tva < 0 || rabais < 0){
            System.out.println("les valeur de tva et de rabais doit etre positive");
            return false;

        }
        if (datecreation == null || datecreation.isAfter(LocalDate.now())){
            System.out.println("Date de creation invalide.");
            return false;
        }
        return true;

    }


    public String toString(){
        return "Facture{" +"id="+ id +
                ", clientId=" +clientId+
                ", montant=" +montant+
                ",statu='" +statut+'\''+
                ",satecreation="+datecreation+
                ", tva=" + tva +
                ", rabais=" + rabais +
                ", montantTotal=" + calculerMontantTotal() +'}';
    }

}



