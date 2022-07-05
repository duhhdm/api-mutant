package com.mercadolivre.apimutante.service;

import com.mercadolivre.apimutante.service.impl.ValidateServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ValidateServiceTest {

    @InjectMocks
    ValidateServiceImpl validateServiceImpl;

    @Test
    public void isValidHorizontalOk(){
        String[] dna = {"ZZZZGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        boolean test = validateServiceImpl.isValidHorizontal(dna);
        assertTrue(test);
    }

    @Test
    public void isValidHorizontalNotOk(){
        String[] dna = {"ZZXZGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        boolean test = validateServiceImpl.isValidHorizontal(dna);
        assertFalse(test);
    }

    @Test
    public void isValidVerticalOk(){
        String[] dna = {"ZZZXGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        boolean test = validateServiceImpl.isValidVertical(dna);
        assertTrue(test);
    }

    @Test
    public void isValidVerticalNotOk(){
        String[] dna = {"ZZZXGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        boolean test = validateServiceImpl.isValidVertical(dna);
        assertFalse(test);
    }
    @Test
    public void isValidDiagonalOk(){
        String[] dna = {"ZZHZGA", "ZETGXC", "GTMDUT", "ZAGMGX", "ZCYCMA", "BCACTM"};
        boolean test = validateServiceImpl.isValidDiagonal(dna);
        assertTrue(test);
    }

    @Test
    public void isValidDiagonalNotOk(){
        String[] dna = {"XZZZGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        boolean test = validateServiceImpl.isValidDiagonal(dna);
        assertFalse(test);
    }
    @Test
    public void isValidateDnaNotOkDnaIsIncorret(){
        String[] dna = {"XZZZGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA"};
        assertEquals(validateServiceImpl.isErroValidation(dna),"Dna informado incorreto");
    }

    @Test
    public void isValidateDnaNotOk(){
        String[] dna = {"XZZZGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        assertEquals(validateServiceImpl.isErroValidation(dna),"");
    }
}
