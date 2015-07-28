package com.example.administrador.myapplication.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrador on 27/07/2015.
 */
public class ClientAddress implements Serializable, Parcelable{

    private String cep;
    private String tipoDeLogradouro;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

    public ClientAddress() {
        super();
    }

    public ClientAddress(Parcel in) {
        super();
        readToParcel(in);
    }
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientAddress address = (ClientAddress) o;

        if (cep != null ? !cep.equals(address.cep) : address.cep != null) return false;
        if (tipoDeLogradouro != null ? !tipoDeLogradouro.equals(address.tipoDeLogradouro) : address.tipoDeLogradouro != null)
            return false;
        if (logradouro != null ? !logradouro.equals(address.logradouro) : address.logradouro != null)
            return false;
        if (bairro != null ? !bairro.equals(address.bairro) : address.bairro != null) return false;
        if (cidade != null ? !cidade.equals(address.cidade) : address.cidade != null) return false;
        return !(estado != null ? !estado.equals(address.estado) : address.estado != null);

    }

    @Override
    public int hashCode() {
        int result = cep != null ? cep.hashCode() : 0;
        result = 31 * result + (tipoDeLogradouro != null ? tipoDeLogradouro.hashCode() : 0);
        result = 31 * result + (logradouro != null ? logradouro.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cep == null ? "" : cep);
        dest.writeString(tipoDeLogradouro == null ? "" : tipoDeLogradouro);
        dest.writeString(logradouro == null ? "" : logradouro);
        dest.writeString(bairro == null ? "" : bairro);
        dest.writeString(cidade == null ? "" : cidade);
        dest.writeString(estado == null ? "" : estado);

    }

    private void readToParcel(Parcel in) {
        cep = in.readString();
        tipoDeLogradouro = in.readString();
        logradouro = in.readString();
        bairro = in.readString();
        cidade = in.readString();
        estado = in.readString();
    }

    public static final Parcelable.Creator<ClientAddress> CREATOR = new Parcelable.Creator<ClientAddress>() {


        @Override
        public ClientAddress createFromParcel(Parcel source) {
            return new ClientAddress(source);
        }

        @Override
        public ClientAddress[] newArray(int size) {
            return new ClientAddress[size];
        }
    };
}
