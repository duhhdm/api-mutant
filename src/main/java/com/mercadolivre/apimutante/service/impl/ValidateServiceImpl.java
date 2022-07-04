package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.model.ErroValidation;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Override
    public boolean isValidDiagonal(String[] component) {
        int isCompareValue = 1;
        int position = 1;
        int countList = 0;
        String letter = "";
        for (int i = 0; i< component.length; i++) {

            if(component.length-1<position || component.length-1<i)
                return false;
            String[] listLetter = Dna.lineLetter(i,component);
            String[] listLetterCompare = Dna.lineLetter(position,component);

            if(!Dna.compareComponent(listLetter[i],listLetterCompare[position],letter)){
                isCompareValue = 1;
            }
            if(position>4 && isCompareValue<=4) {
                if(position<=4 && countList>5)
                    position = countList -1;
                else
                    position = countList + 1;
                i = countList++;
            }

            letter = listLetter[position];
            position++;
            isCompareValue++;
            if(isCompareValue==4)
                return true;
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
