package com.example.administrador.myapplication.model.entities;

/**
 * Created by Administrador on 27/07/2015.
 */
public class ClientAddress {

    private String cep;
    private String tipoDeLogradouro;
    private String logradouro;
    private String barirro;
    private String cidade;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoDeLogradouro() {
        return tipoDeLogradouro;
    }

    public void setTipoDeLogradouro(String tipoDeLogradouro) {
        this.tipoDeLogradouro = tipoDeLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBarirro() {
        return barirro;
    }

    public void setBarirro(String barirro) {
        this.barirro = barirro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
