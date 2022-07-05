package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.model.ContModelDiagonal;
import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
        int contProcess = 0;
        int contTotal = 0;
        boolean start = true;
        boolean muda = false;
        String letter = "";
        ContModelDiagonal contModelDiagonal = new ContModelDiagonal(countListFixe, countList, countListCompare, isValidLetter, positionLetterFixe, positionLetter, positionLetterCompare, contProcess, contTotal, start, muda, letter);
        while (contModelDiagonal.isStart()) {

//            if (contProcess < component.length) {
            String[] listLetter = Dna.lineLetter(contModelDiagonal.getCountList(), component);
            String[] listLetterCompare = Dna.lineLetter(contModelDiagonal.getCountListCompare(), component);
            if (!Dna.compareComponent(listLetter[contModelDiagonal.getPositionLetter()],
                    listLetterCompare[contModelDiagonal.getPositionLetterCompare()], contModelDiagonal.getLetter())) {
                contModelDiagonal.setIsValidLetter(1);
            }
            contModelDiagonal.setLetter(listLetterCompare[contModelDiagonal.getPositionLetterCompare()]);
            contModelDiagonal.setIsValidLetter(contModelDiagonal.getIsValidLetter() + 1);
//                if (countList < component.length - 2)
//                    countList++;
//                if (countListCompare < component.length - 1)
//                    countListCompare++;
//                if (positionLetter <= component.length - 2)
//                    positionLetter++;
//                if (positionLetterCompare < component.length - 1)
//                    positionLetterCompare++;
            contModelDiagonal = contModelDiagonal.sumList(component, contModelDiagonal);
            contModelDiagonal = contModelDiagonal.sumListFixe(contModelDiagonal, component, listLetter);
//                if (contModelDiagonal.getIsValidLetter() < 3 && contModelDiagonal.getPositionLetter() > listLetter.length - 2) {
//                    contTotal++;
//                    countListFixe = contProcess;
//                    if (countListFixe <= component.length - 2) {
//                        countList = countListFixe;
//                        countListCompare = countListFixe + 1;
//                    }
//                    positionLetterFixe = contTotal + 1;
//                    if (contTotal >= component.length - 1) {
//                        contProcess++;
//                        muda = true;
//                        positionLetterFixe = 0;
//                    }
//                    if (muda) {
//                        contTotal = contProcess;
//                        muda = false;
//                    }
//                    if (positionLetterFixe <= component.length - 2)
//                        positionLetter = positionLetterFixe;
//                    if (positionLetterFixe <= component.length - 2) {
//                        positionLetterCompare = positionLetterFixe + 1;
//                    }

//                if (isValidLetter < 3 && positionLetter > listLetter.length - 2) {
//                    contTotal++;
//                    countListFixe = contProcess;
//                    if (countListFixe <= component.length - 2) {
//                        countList = countListFixe;
//                        countListCompare = countListFixe + 1;
//                    }
//                    positionLetterFixe = contTotal + 1;
//                    if (contTotal >= component.length - 1) {
//                        contProcess++;
//                        muda = true;
//                        positionLetterFixe = 0;
//                    }
//                    if (muda) {
//                        contTotal = contProcess;
//                        muda = false;
//                    }
//                    if (positionLetterFixe <= component.length - 2)
//                        positionLetter = positionLetterFixe;
//                    if (positionLetterFixe <= component.length - 2) {
//                        positionLetterCompare = positionLetterFixe + 1;
//                    }
            if (contModelDiagonal.getIsValidLetter() == 4)
                return true;
            if (contModelDiagonal.getContProcess() > component.length - 1)
                contModelDiagonal.setStart(false);
        }
//            }

//        }

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
