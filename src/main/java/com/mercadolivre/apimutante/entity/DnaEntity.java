package com.mercadolivre.apimutante.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="tbDna")
public class DnaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column
    Date date;

    @Column
    String dna;

    @Column
    String isMutant;

    public DnaEntity(Integer id, Date date, String dna, String isMutant) {
        this.id = id;
        this.date = date;
        this.dna = dna;
        this.isMutant=isMutant;
    }

    public DnaEntity(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public String getMutant() {
        return isMutant;
    }

    public void setMutant(String mutant) {
        isMutant = mutant;
    }
}
