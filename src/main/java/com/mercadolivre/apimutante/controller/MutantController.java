package com.mercadolivre.apimutante.controller;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.model.ErroValidation;
import com.mercadolivre.apimutante.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@RestController
public class MutantController {

    @Autowired
    MutantService mutantService;

    @PostMapping("mutant")
    public ResponseEntity<Object> isMutant(@RequestBody Dna dna){
        String validate =mutantService.validateDna(dna.getDna());
        if(!validate.isEmpty())
            return ResponseEntity.badRequest().body(new ErroValidation(validate,new Date()));
        if(mutantService.isMutant(dna.getDna()))
            return ResponseEntity.ok().build();
        return  ResponseEntity.status(403).build();
    }

    @GetMapping("stats")
    public ResponseEntity<Object> stats(){
        return ResponseEntity.ok(mutantService.countMutant());
    }
}
