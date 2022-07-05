package com.mercadolivre.apimutante.service;

public interface ValidateService {

    boolean isValidDiagonal(String[] component);
    boolean isValidVertical(String[] component);
    boolean isValidHorizontal(String[] component);
    String isErroValidation(String[] component);

}
