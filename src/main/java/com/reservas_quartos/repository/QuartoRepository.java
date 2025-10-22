package com.reservas_quartos.repository;


import com.reservas_quartos.Entity.Quarto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto,Long> {
    List<Quarto> findByStatus(String status);
}