package com.reservas_quartos.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter
@Setter
@Log
@Table
@Entity


public class Pagamento {
    @Id
    @GeneratedValue

    private Long idpagamento;
    private Data dataPagamento;
    private String valor;

    public Pagamento(Long idpagamento,Data dataPagamento,String valor) {
        this.idpagamento = idpagamento;
        this.dataPagamento=dataPagamento;
        this.valor=valor;
    }

    public Long getIdpagamento() {
        return idpagamento;
    }

    public Data getDataPagamento() {
        return dataPagamento;
    }

    public String getValor() {
        return valor;
    }

    public void setIdpagamento(Long idpagamento) {
        this.idpagamento = idpagamento;
    }

    public void setDataPagamento(Data dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}

