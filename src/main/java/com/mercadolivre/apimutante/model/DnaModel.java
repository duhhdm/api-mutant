package com.mercadolivre.apimutante.model;

import com.mercadolivre.apimutante.entity.DnaEntity;

import java.util.Arrays;
import java.util.Date;

public class Dna {
    private String[] dna;


    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public static boolean compareComponent(String compare1, String compare2, String letter){
        if(compare1.equals(compare2) && letter.isEmpty()){
            return true;
        }else return compare1.equals(compare2) && compare2.equals(letter);
    }

    public static String[] lineLetter(int index, String[] component){
        return component[index].split("(?!^)");
    }

    public static DnaEntity convertDnaEntity(String dna,String isMutant){
        return new DnaEntity(null,new Date(),dna,isMutant);
    }

    @Override
    public String toString() {
        return
                Arrays.toString(dna);

    }
}
