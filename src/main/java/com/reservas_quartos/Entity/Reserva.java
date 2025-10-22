package com.reservas_quartos.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Entity
@Table
@Log
@Getter
@Setter

public class Reserva {
    @Id
    @GeneratedValue
    private Long idReserva;
    private Data dataCheckout;
    private Data dataChekin;

    public Reserva(Long idReserva,Data dataCheckout,Data dataChekin) {
        this.idReserva = idReserva;
        this.dataCheckout=dataCheckout;
        this.dataChekin=dataChekin;
    }

    @ManyToMany
    @JoinColumn(name = "cliente_id")
    private Cliente clientes;

    @ManyToMany
    @JoinColumn(name = "quarto_id")
    private Quarto quartos;

    @OneToMany
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamentos;


    public Long getIdReserva() {
        return idReserva;
    }

    public Data getDataCheckout() {
        return dataCheckout;
    }


    public Data getDataChekin() {
        return dataChekin;
    }

    public Cliente getClientes() {
        return clientes;

    }


    public Quarto getQuartos() {
        return quartos;
    }

    public Pagamento getPagamentos() {
        return pagamentos;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public void setDataCheckout(Data dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public void setDataChekin(Data dataChekin) {
        this.dataChekin = dataChekin;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public void setQuartos(Quarto quartos) {
        this.quartos = quartos;
    }

    public void setPagamentos(Pagamento pagamentos) {
        this.pagamentos = pagamentos;
    }
}



