package com.reservas_quartos.repository;




import  com.reservas_quartos.Entity.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PagamentoRepository extends CrudRepository<Pagamento,Long> {
}

