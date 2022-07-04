package com.mercadolivre.apimutante.model;

import java.util.Date;

public class ErroValidation {
    private String erro;
    private Date date;

    public ErroValidation(){}

    public ErroValidation(String erro, Date date) {
        this.erro = erro;
        this.date = date;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
