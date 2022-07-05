package com.mercadolivre.apimutante.controller;

import com.google.gson.Gson;
import com.mercadolivre.apimutante.entity.DnaEntity;
import com.mercadolivre.apimutante.model.DnaModel;
import com.mercadolivre.apimutante.model.MutantEnun;
import com.mercadolivre.apimutante.model.StatsModel;
import com.mercadolivre.apimutante.repository.DnaRepository;
import com.mercadolivre.apimutante.service.MutantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MutantControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MutantService mutantService;

    @MockBean
    DnaRepository dnaRepository;

    @Test
    public void isMutantTrue() throws Exception {
        DnaModel dnaModel = new DnaModel();
        String[] list = {"ZZZXGA",
                "AGZXGC",
                "ZTAZGT",
                "ZAGYZG",
                "ZCYCTA",
                "BCACTG"};
        dnaModel.setDna(list);
        Gson gson = new Gson();
        String json = gson.toJson(dnaModel);
        Mockito.when(mutantService.validateDna(dnaModel.getDna())).thenReturn("");
        Mockito.when(mutantService.isMutant(list)).thenReturn(true);
        Mockito.when(dnaRepository.save(DnaModel.convertDnaEntity(list.toString(), MutantEnun.MUTANT.toString()))).thenReturn(DnaModel.convertDnaEntity(list.toString(), MutantEnun.MUTANT.toString()));
        this.mockMvc.perform(post("/mutant").content(json)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void isMutantFalse() throws Exception {
        DnaModel dnaModel = new DnaModel();
        String[] list = {"ZGYGGA", "ZAGTGC", "XTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        dnaModel.setDna(list);
        Gson gson = new Gson();
        String json = gson.toJson(dnaModel);
        Mockito.when(mutantService.validateDna(dnaModel.getDna())).thenReturn("");
        Mockito.when(mutantService.isMutant(list)).thenReturn(false);
        Mockito.when(dnaRepository.save(DnaModel.convertDnaEntity(list.toString(), MutantEnun.MUTANT.toString()))).thenReturn(DnaModel.convertDnaEntity(list.toString(), MutantEnun.MUTANT.toString()));
        this.mockMvc.perform(post("/mutant").content(json)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    public void isMutantValidateInvalid() throws Exception {
        DnaModel dnaModel = new DnaModel();
        String[] list = {"ABC"};
        dnaModel.setDna(list);
        Gson gson = new Gson();
        String json = gson.toJson(dnaModel);
        Mockito.when(mutantService.validateDna(dnaModel.getDna())).thenReturn("Nenhum dna informado");
        this.mockMvc.perform(post("/mutant").content(json)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void statsIsOk() throws Exception {
        String[] dnaMutant = {"ZGYGGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        String[] dnaHuman = {"ZGYGGA", "ZAGTGC", "HTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"};
        DnaEntity dnaEntityMutant = new DnaEntity(1,new Date(),dnaMutant.toString(),MutantEnun.MUTANT.toString());
        DnaEntity dnaEntityHuman = new DnaEntity(2, new Date(),dnaHuman.toString(),MutantEnun.HUMAN.toString());
        List<DnaEntity> dnaEntityList = new ArrayList<>();
        dnaEntityList.add(dnaEntityMutant);
        dnaEntityList.add(dnaEntityHuman);
        Mockito.when(mutantService.countMutant()).thenReturn(new StatsModel(1,1,1.0));
        Mockito.when(dnaRepository.findAll()).thenReturn(dnaEntityList);
        this.mockMvc.perform(get("/stats")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
