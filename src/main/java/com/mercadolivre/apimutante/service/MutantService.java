package com.mercadolivre.apimutante.service;

import org.springframework.stereotype.Service;

@Service
public interface MutantService {
    public boolean isMutant(String[] dna);
}
