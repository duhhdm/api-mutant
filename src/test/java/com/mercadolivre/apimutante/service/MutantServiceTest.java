package com.mercadolivre.apimutante.service;

import com.mercadolivre.apimutante.model.Dna;
import com.mercadolivre.apimutante.model.MutantEnun;
import com.mercadolivre.apimutante.repository.DnaRepository;
import com.mercadolivre.apimutante.service.impl.MutantServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MutantServiceTest {

    @MockBean
    MutantService mutantService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DnaRepository dnaRepository;


    @Test
    public void isMutantReturnHorizontalTrue(){
        String[] dna = {"ZZZZGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        Mockito.when(mutantService.isMutant(dna)).thenReturn(true);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertTrue(mutantService.isMutant(dna));
    }
    @Test
    public void isMutantVerticalReturnTrue(){
        String[] dna = {"ZZZXGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        Mockito.when(mutantService.isMutant(dna)).thenReturn(true);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void isMutantDiagonalReturnTrue(){
        String[] dna = {"ZZHZGA", "ZETGXC", "GTMDUT", "ZAGMGX", "ZCYCMA", "BCACTM"};
        Mockito.when(mutantService.isMutant(dna)).thenReturn(true);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertTrue(mutantService.isMutant(dna));
    }


    @Test
    public void isMutantReturnHorizontalFalse(){
        String[] dna = {"ZZXZGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        Mockito.when(mutantService.isMutant(dna)).thenReturn(false);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertFalse(mutantService.isMutant(dna));
    }
    @Test
    public void isMutantVerticalReturnFalse(){
        String[] dna = {"ZZZXGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        Mockito.when(mutantService.isMutant(dna)).thenReturn(false);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertFalse(mutantService.isMutant(dna));
    }

    @Test
    public void isMutantDiagonalReturnFalse(){
        String[] dna = {"XZZZGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};;
        Mockito.when(mutantService.isMutant(dna)).thenReturn(false);
        Mockito.when(dnaRepository.save(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()))).thenReturn(Dna.convertDnaEntity(dna.toString(), MutantEnun.MUTANT.toString()));
        assertFalse(mutantService.isMutant(dna));
    }

}
