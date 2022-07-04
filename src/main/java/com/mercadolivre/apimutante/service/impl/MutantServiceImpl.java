package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.entity.DnaEntity;
import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.model.ErroValidation;
import com.mercadolivre.apimutante.model.MutantEnun;
import com.mercadolivre.apimutante.model.StatsModel;
import com.mercadolivre.apimutante.repository.DnaRepository;
import com.mercadolivre.apimutante.service.MutantService;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
            dnaRepository.save(Dna.convertDnaEntity(Arrays.toString(dna),MutantEnun.MUTANT.toString()));
            return true;
        }
        dnaRepository.save(Dna.convertDnaEntity(Arrays.toString(dna), MutantEnun.HUMAN.toString()));
        return false;
    }

    @Override
    public String validateDna(String[] dna) {
        return validateService.isErroValidation(dna);
    }

    @Override
    public StatsModel countMutant() {
        List<DnaEntity> list = dnaRepository.findAll();
        StatsModel statsModel = new StatsModel();
        Double mutant = 0.0;
        Double human = 0.0;
        Double ratio = 0.0;
        for (DnaEntity dna: list
             ) {

            if(dna.getMutant().equals(MutantEnun.MUTANT.toString()))
                mutant++;
            human++;
        }
        if(human!=0.0 && mutant!=0.0)
            ratio=mutant/human;

        return new StatsModel(mutant.intValue(),human.intValue(),ratio);
    }


}
