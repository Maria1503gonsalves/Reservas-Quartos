package com.reservas_quartos.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@Entity
@Table
@Log
@Setter
@Getter
public class Cliente {
    @Id
    @GeneratedValue
    private Long idCliente;
    private String nome;
    private String telefone;
    private int cpf;


    public Long getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }


    public int getCpf() {
        return cpf;
    }


    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Cliente(Long idCliente, String nome, String telefone, int cpf) {
        this.idCliente=idCliente;
        this.nome=nome;
        this.telefone=telefone;
        this.cpf=cpf;



    }
}


