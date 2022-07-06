package com.mercadolivre.apimutante.model;

public class ContModelDiagonal {

    private Integer countListFixe ;
    private Integer countList ;
    private Integer countListCompare ;
    private Integer isValidLetter ;
    private Integer positionLetterFixe ;
    private Integer positionLetter ;
    private Integer positionLetterCompare ;
    private Integer contProcess;
    private Integer contTotal;
    boolean start;
    boolean muda;
    String letter;


    public ContModelDiagonal(Integer countListFixe, Integer countList, Integer countListCompare, Integer isValidLetter, Integer positionLetterFixe, Integer positionLetter, Integer positionLetterCompare, Integer contProcess, Integer contTotal, boolean start, boolean muda, String letter) {
        this.countListFixe = countListFixe;
        this.countList = countList;
        this.countListCompare = countListCompare;
        this.isValidLetter = isValidLetter;
        this.positionLetterFixe = positionLetterFixe;
        this.positionLetter = positionLetter;
        this.positionLetterCompare = positionLetterCompare;
        this.contProcess = contProcess;
        this.contTotal = contTotal;
        this.start = start;
        this.muda = muda;
        this.letter = letter;
    }

    public Integer getCountListFixe() {
        return countListFixe;
    }

    public void setCountListFixe(Integer countListFixe) {
        this.countListFixe = countListFixe;
    }

    public Integer getCountList() {
        return countList;
    }

    public void setCountList(Integer countList) {
        this.countList = countList;
    }

    public Integer getCountListCompare() {
        return countListCompare;
    }

    public void setCountListCompare(Integer countListCompare) {
        this.countListCompare = countListCompare;
    }

    public Integer getIsValidLetter() {
        return isValidLetter;
    }

    public void setIsValidLetter(Integer isValidLetter) {
        this.isValidLetter = isValidLetter;
    }

    public Integer getPositionLetterFixe() {
        return positionLetterFixe;
    }

    public void setPositionLetterFixe(Integer positionLetterFixe) {
        this.positionLetterFixe = positionLetterFixe;
    }

    public Integer getPositionLetter() {
        return positionLetter;
    }

    public void setPositionLetter(Integer positionLetter) {
        this.positionLetter = positionLetter;
    }

    public Integer getPositionLetterCompare() {
        return positionLetterCompare;
    }

    public void setPositionLetterCompare(Integer positionLetterCompare) {
        this.positionLetterCompare = positionLetterCompare;
    }

    public Integer getContProcess() {
        return contProcess;
    }

    public void setContProcess(Integer contProcess) {
        this.contProcess = contProcess;
    }

    public Integer getContTotal() {
        return contTotal;
    }

    public void setContTotal(Integer contTotal) {
        this.contTotal = contTotal;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isMuda() {
        return muda;
    }

    public void setMuda(boolean muda) {
        this.muda = muda;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public ContModelDiagonal sumList(String[] component, ContModelDiagonal contModelDiagonal){
        if (contModelDiagonal.getCountList() < component.length - 2)
            contModelDiagonal.setCountList(contModelDiagonal.getCountList()+1);
        if (contModelDiagonal.getCountListCompare() < component.length - 1)
            contModelDiagonal.setCountListCompare(contModelDiagonal.getCountListCompare()+1);
        if (contModelDiagonal.getPositionLetter() <= component.length - 2)
            contModelDiagonal.setPositionLetter(contModelDiagonal.getPositionLetter()+1);
        if (contModelDiagonal.getPositionLetterCompare() < component.length - 1)
            contModelDiagonal.setPositionLetterCompare(contModelDiagonal.getPositionLetterCompare()+1);
        return contModelDiagonal;
    }

    public ContModelDiagonal sumListFixe(ContModelDiagonal contModelDiagonal, String[] component, String[] listLetter){
        if (contModelDiagonal.getIsValidLetter() < 3 && contModelDiagonal.getPositionLetter() > listLetter.length - 2) {
            contModelDiagonal.setContTotal(contModelDiagonal.getContTotal() + 1);
            contModelDiagonal.setCountListFixe(contModelDiagonal.getContProcess());
            if (contModelDiagonal.getCountListFixe() <= component.length - 2) {
                contModelDiagonal.setCountList(contModelDiagonal.getCountListFixe());
                contModelDiagonal.setCountListCompare(contModelDiagonal.getCountListFixe() + 1);
            }
            contModelDiagonal.setPositionLetterFixe(contModelDiagonal.getContTotal() + 1);
            if (contModelDiagonal.getContTotal() >= component.length - 1) {
                contModelDiagonal.setContProcess(contModelDiagonal.getContProcess() + 1);
                contModelDiagonal.setMuda(true);
                contModelDiagonal.setPositionLetterFixe(0);
            }
            if (contModelDiagonal.getPositionLetterFixe() <= component.length - 2)
                        contModelDiagonal.setPositionLetter(contModelDiagonal.getPositionLetterFixe()) ;
                    if (contModelDiagonal.getPositionLetterFixe() <= component.length - 2) {
                        contModelDiagonal.setPositionLetterCompare(contModelDiagonal.getPositionLetterFixe() + 1) ;
                    }

                if (contModelDiagonal.getIsValidLetter() < 3 && contModelDiagonal.getPositionLetter() > listLetter.length - 2) {
                    contModelDiagonal.setContTotal(contModelDiagonal.getContTotal() + 1);
                    contModelDiagonal.setCountListFixe(contModelDiagonal.getContProcess());
                    if (contModelDiagonal.getCountListFixe() <= component.length - 2) {
                        contModelDiagonal.setCountList(contModelDiagonal.getCountListFixe());
                        contModelDiagonal.setCountListCompare(contModelDiagonal.getCountListFixe() + 1);
                    }
                    contModelDiagonal.setPositionLetterFixe(contModelDiagonal.getContTotal() + 1);
                    if (contModelDiagonal.getContTotal() >= component.length - 1) {
                        contModelDiagonal.setContProcess(contModelDiagonal.getContProcess() + 1);
                        contModelDiagonal.setMuda(true);
                        contModelDiagonal.setPositionLetterFixe(0);
                    }
                    if (contModelDiagonal.isMuda()) {
                        contModelDiagonal.setContTotal(contModelDiagonal.getContProcess());
                        contModelDiagonal.setMuda(false);
                    }
                    if (contModelDiagonal.getPositionLetterFixe() <= component.length - 2)
                        contModelDiagonal.setPositionLetter(contModelDiagonal.getPositionLetterFixe());
                    if (contModelDiagonal.getPositionLetterFixe() <= component.length - 2) {
                        contModelDiagonal.setPositionLetterCompare(contModelDiagonal.getPositionLetterFixe() + 1);
                    }
                }

        }
        return contModelDiagonal;
    }
}
