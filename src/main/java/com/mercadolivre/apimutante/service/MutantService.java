package com.mercadolivre.apimutante.service;

import com.mercadolivre.apimutante.model.StatsModel;
import org.springframework.stereotype.Service;

@Service
public interface MutantService {
    boolean isMutant(String[] dna);
    String validateDna(String[] dna);
    StatsModel countMutant();
}
