package com.reservas_quartos.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Table
@Log
@Getter
@Setter

public class Quarto {
    @Id
    @GeneratedValue
    private Long idQuarto;
    private int numero;
    private String tipo;
    private Double precoDiaria;
    private String status;

    public Long getIdQuarto() {
        return idQuarto;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public String getStatus() {
        return status;
    }

    public void setIdQuarto(Long idQuarto) {
        this.idQuarto = idQuarto;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Quarto(Long idQuarto, int numero, Double precoDiaria, String status, String tipo) {
        this.idQuarto = idQuarto;
        this.numero=numero;
        this.precoDiaria=precoDiaria;
        this.status=status;
        this.tipo=tipo;


    }
}

