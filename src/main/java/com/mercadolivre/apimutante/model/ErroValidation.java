package com.mercadolivre.apimutante.model;

import java.util.Date;

public class ErroValidation {
    private String erro;

    public ErroValidation(){}

    public ErroValidation(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

}
