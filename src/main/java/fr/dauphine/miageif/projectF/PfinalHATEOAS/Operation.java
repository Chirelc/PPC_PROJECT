package fr.dauphine.miageif.projectF.PfinalHATEOAS;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Operation {

    @Id
    private long id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Compte source;

    private String sourceIban;

    @ManyToOne
    private Compte destination;

    private String destIban;

    private String devise;

    private Date date;

    private BigDecimal montant;



    public Operation() {

    }

    public Operation( long id,String type, Compte source, Compte destination,String devise,BigDecimal montant) {
        super();
        this.id=id;
        this.type = type;
        this.montant= montant;
        this.source=source;
        this.destination=destination;
        this.devise=devise;
        this.date=new Date();
        this.destIban=destination.getIban();
        this.sourceIban=source.getIban();


    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Compte getSource() {
        return source;
    }

    public String getSourceIban() {
        return sourceIban;
    }

    public Compte getDestination() {
        return destination;
    }

    public String getDestIban() {
        return destIban;
    }

    public String getDevise() {
        return devise;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

}
