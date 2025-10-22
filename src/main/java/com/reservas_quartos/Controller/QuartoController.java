package com.reservas_quartos.Controller;


import com.reservas_quartos.Entity.Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservas_quartos.repository.QuartoRepository;
import com.reservas_quartos.service.QuartoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class QuartoController {

    @Autowired
    private QuartoService quartoService;


    @PostMapping
    public ResponseEntity<Quarto> novoQuarto(@RequestBody Quarto quarto) {
        Quarto novoQuarto = quartoService.novoQuarto(quarto);
        return ResponseEntity.ok(novoQuarto);

    }

    @GetMapping
    public List<Quarto> obterTodosQuartos() {
        return quartoService.obterTodosQuartos();
    }

    @Autowired

    private QuartoRepository quartoRepository;

    @PutMapping
    public ResponseEntity<Quarto> atualizarQuarto(@PathVariable Long id, @RequestBody Quarto quartoAtualizado) {
        Optional<Quarto> quartoOptional = quartoRepository.findById(id);


        if (quartoOptional.isPresent()) {
            Quarto quarto = quartoOptional.get();
            quarto.setIdQuarto(quartoAtualizado.getIdQuarto());
            quarto.setNumero(quartoAtualizado.getNumero());
            quarto.setStatus(quartoAtualizado.getStatus());
            quarto.setPrecoDiaria(quartoAtualizado.getPrecoDiaria());
            quarto.setTipo(quartoAtualizado.getTipo());

            Quarto quartoAtualizadoDb = quartoRepository.save(quarto);
            return ResponseEntity.ok().body(quartoAtualizadoDb);

        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @DeleteMapping("/Quarto/{id}")

    public ResponseEntity<Void>excluirQuarto(@PathVariable Long id){
        quartoService.excluirQuarto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("disponiblidade")
    public ResponseEntity<List<Quarto>>consultarDisponiblidade(){
        List<Quarto>quartosDisponiveis=quartoService.consultarDisponibilidade();
        return ResponseEntity.ok(quartosDisponiveis);
    }
}
