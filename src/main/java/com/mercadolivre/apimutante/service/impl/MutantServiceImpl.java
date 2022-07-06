package com.mercadolivre.apimutante.service.impl;

import com.mercadolivre.apimutante.entity.DnaEntity;
import com.mercadolivre.apimutante.model.DnaModel;
import com.mercadolivre.apimutante.model.MutantEnun;
import com.mercadolivre.apimutante.model.StatsModel;
import com.mercadolivre.apimutante.repository.DnaRepository;
import com.mercadolivre.apimutante.service.MutantService;
import com.mercadolivre.apimutante.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

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
            dnaRepository.save(DnaModel.convertDnaEntity(Arrays.toString(dna).toUpperCase(Locale.ROOT),MutantEnun.MUTANT.toString()));
            return true;
        }
        dnaRepository.save(DnaModel.convertDnaEntity(Arrays.toString(dna), MutantEnun.HUMAN.toString()));
        return false;
    }

    @Override
    public String validateDna(String[] dna) {
        return validateService.isErroValidation(dna);
    }

    @Override
    public StatsModel countMutant() {
        List<DnaEntity> list = dnaRepository.findAll();
        Double mutant = 0.0;
        Double human = 0.0;
        BigDecimal ratio = BigDecimal.ZERO;
        for (DnaEntity dna: list
             ) {

            if(dna.getMutant().equals(MutantEnun.MUTANT.toString()))
                mutant++;
            human++;
        }
        if(human!=0.0 && mutant!=0.0)
            ratio=BigDecimal.valueOf(mutant/human);

        return new StatsModel(mutant.intValue(),human.intValue(),ratio.doubleValue());
    }


}
