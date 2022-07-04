package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.repository.DnaRepository;
import com.mercadolivre.apimutante.service.MutantService;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MutantServiceImpl implements MutantService {

    @Autowired
    private ValidateService validateService;

    @Autowired
    private DnaRepository dnaRepository;

    @Override
    public boolean isMutant(String[] dna) {

        if(validateService.isValidVertical(dna) ||
                validateService.isValidDiagonal(dna) ||
                validateService.isValidHorizontal(dna)) {
            dnaRepository.save(Dna.convertDnaEntity(Arrays.toString(dna),true));
            return true;
        }
        dnaRepository.save(Dna.convertDnaEntity(Arrays.toString(dna),false));
        return false;
    }

}
