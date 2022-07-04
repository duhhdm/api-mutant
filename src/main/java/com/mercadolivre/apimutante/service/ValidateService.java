package com.mercadolivre.apimutante.service;

import com.mercadolivre.apimutante.model.ErroValidation;
import org.springframework.http.ResponseEntity;

public interface ValidateService {

    boolean isValidDiagonal(String[] component);
    boolean isValidVertical(String[] component);
    boolean isValidHorizontal(String[] component);
    String isErroValidation(String[] component);

}
