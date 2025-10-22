package com.reservas_quartos.Controller;

import com.reservas_quartos.Entity.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.reservas_quartos.service.ReservaService;

import java.util.Optional;

@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping

    public ResponseEntity<Reserva>novaReserva(@RequestBody Reserva reserva) {

        if (reserva == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            Reserva novaReserva = reservaService.novaReserva(reserva);
            return ResponseEntity.ok(novaReserva);
        } catch (Exception e) {
            // Lida com possíveis exceções
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping("/{id}")
    public Optional<Reserva> consultarReserva(@PathVariable Long id){
        return reservaService.consultarReserva(id);
    }

    @PutMapping
    public ResponseEntity<Reserva>atualizarReserva(@PathVariable Long id,@RequestBody Reserva reservaAtualizada){
        Reserva  reserva = reservaService.atualizarReserva(id,reservaAtualizada);
        return ResponseEntity.ok(reserva);
    }

    @GetMapping
    public ResponseEntity<Reserva>buscarReservaPeloNome(@PathVariable Long id){
        Reserva reserva = reservaService.buscarReservapeloNome(id);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping
    public ResponseEntity<Void>excluirReserva(@PathVariable Long id){
        reservaService.excluirReserva(id);
        return ResponseEntity.noContent().build();
    }


}







