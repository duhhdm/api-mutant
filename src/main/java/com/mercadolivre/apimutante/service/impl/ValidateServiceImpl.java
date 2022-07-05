package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.model.ErroValidation;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Override
    public boolean isValidDiagonal(String[] component) {
        int countListFixe = 0;
        int countList = 0;
        int countListCompare = 1;
        int isValidLetter = 1;
        int positionLetterFixe = 0;
        int positionLetter = 0;
        int positionLetterCompare = 1;
        int contProcess=0;
        int contTotal = 0;
        boolean start = true;
        boolean muda = false;
        String letter = "";
        while (start) {
            String[] listLetter = Dna.lineLetter(countList, component);
            String[] listLetterCompare = Dna.lineLetter(countListCompare, component);
            if (!Dna.compareComponent(listLetter[positionLetter], listLetterCompare[positionLetterCompare], letter)) {
                isValidLetter = 1;
            }
            letter = listLetterCompare[positionLetterCompare];
            isValidLetter++;
            if(countList<component.length-2)
                countList++;
            if(countListCompare<component.length-1)
                countListCompare++;
            if(positionLetter<= component.length-2)
                positionLetter++;
            if(positionLetterCompare< component.length-1)
                positionLetterCompare++;

            if (isValidLetter < 3 && positionLetter > listLetter.length - 2) {
                contTotal++;
                countListFixe= contProcess;
                if(countListFixe<=component.length-2) {
                    countList = countListFixe;
                    countListCompare = countListFixe + 1;
                }
                positionLetterFixe=contTotal+1;
                if(contTotal>= component.length-1) {
                    contProcess++;
                    muda=true;
                    positionLetterFixe=0;
                }
                if(muda){
                    contTotal=contProcess;
                    muda=false;
                }
                if(positionLetterFixe<= component.length-2)
                    positionLetter=positionLetterFixe;
                if(positionLetterFixe<=component.length-2) {
                    positionLetterCompare = positionLetterFixe + 1;
                }
            }
            if (isValidLetter == 4)
                return true;
            if (contProcess > component.length - 1)
                start = false;
        }
        return false;
    }

    @Override
    public boolean isValidVertical(String[] component) {
        int isCompareValue = 1;
        String letter ="";
        for(int i=0; i<component.length;i++){
            for(int y=0; y<component.length;y++){
                if(y<component.length-1) {
                    if (!Dna.compareComponent(String.valueOf(component[y].charAt(i)),String.valueOf(component[y+1].charAt(i)),letter))
                        isCompareValue = 1;
                    if(letter.isEmpty() || !letter.equals(String.valueOf(component[y+1].charAt(i))))
                        letter = String.valueOf(component[y+1].charAt(i));
                }
                isCompareValue++;
                if(isCompareValue>4)
                    return true;

            }
        }
        return false;
    }

    @Override
    public boolean isValidHorizontal(String[] component) {
        for(int i = 0; i< component.length;i++) {
            String[] listLetter = Dna.lineLetter(i,component);
            int isComparaValid = 1;
            for (int y = 0; y < listLetter.length; y++) {
                for(int z = 1+y; z<listLetter.length;z++){
                    String compareInitial = listLetter[y];
                    if (Dna.compareComponent(compareInitial,listLetter[z],listLetter[z-1])) {
                        isComparaValid++;

                    }
                    else{
                        isComparaValid=1;
                    }
                    if (isComparaValid == 4)
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public String isErroValidation(String[] component) {
        int vertical = component.length;
        int horizontal = Dna.lineLetter(1,component).length;

        if(Arrays.asList(component).isEmpty())
            return "Nenhum dna informado";
        if(vertical!=horizontal){
            return "Dna informado incorreto";
        }
        return "";
    }
}
