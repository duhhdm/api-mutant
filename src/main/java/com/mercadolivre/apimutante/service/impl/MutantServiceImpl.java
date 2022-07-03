package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.service.MutantService;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl implements MutantService {

    @Autowired
    private ValidateService validateService;

    @Override
    public boolean isMutant(String[] dna) {
        return validateService.isValidVertical(dna) ||
                validateService.isValidDiagonal(dna) ||
                validateService.isValidHorizontal(dna);
    }

}
