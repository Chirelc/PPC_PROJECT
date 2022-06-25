package fr.dauphine.miageif.projectF.PfinalHATEOAS;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


// Classe persistente representant  un "un compte bancaire "
    @Entity
    public class Compte{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="IBAN")
        private String iban;

        @Column(name="Type de Compte")
        private String type;

        @Column(name="interet")
        private BigDecimal interest;

        @Column(name="Frais de tenue de compte")
        private String frais;
        @OneToMany
        private List<Operation> operations;
    public Compte() {
    }

    public Compte( long id,String iban, String type, BigDecimal interest, String frais) {
        super();
        this.id=id;
            this.iban = iban;
            this.type = type;
            this.interest= interest;
            this.frais=frais;
        }

    public Long getId() {
            return id;
        }

        public String getIban() {
            return iban;
        }

        public String getType() {
            return type;
        }

        public BigDecimal getInterest() {
            return interest;
        }

        public String getFrais() {
            return frais;
        }


    public void setId(Long id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
