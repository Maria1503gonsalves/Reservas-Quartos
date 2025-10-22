package com.reservas_quartos.repository;


import com.reservas_quartos.Entity.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository  extends CrudRepository<Reserva,Long> {
}

