package fr.dauphine.miageif.projectF.PfinalHATEOAS;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="type operation")
    private String type;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private Compte source;

    @Column(name="Iban source ")
    private String sourceIban;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Compte destination;

    @Column(name="Iban destination ")
    private String destIban;

    @Column(name="Devise ")
    private String devise;

    @Column(name = "Date")
    private Date date;

    @Column(name="Montant")
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


    }

    public Long getId() {
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
