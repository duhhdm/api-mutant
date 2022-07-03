package com.mercadolivre.apimutante.controller;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class MutantController {

    @Autowired
    MutantService mutantService;

    @PostMapping("mutant")
    public String isMutant(@RequestBody Dna dna){
        String manipulacao = dna.getDna()[0];
        System.out.println(manipulacao.contains("A"));
        String[] listaManipulada = manipulacao.split(String.valueOf(manipulacao.length()));
        System.out.println(Arrays.toString(listaManipulada));
        System.out.println(mutantService.isMutant(dna.getDna()));
        return dna.toString();
    }
}
