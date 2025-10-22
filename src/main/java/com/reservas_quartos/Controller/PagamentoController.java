package com.reservas_quartos.Controller;

import com.stripe.model.Charge;
import com.reservas_quartos.Entity.Pagamento;
import com.reservas_quartos.service.PagamentoService;
import com.reservas_quartos.service.StripeService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/processar")
    public Map<String, Object> processarPagamento(@RequestParam double valor, @RequestParam String tokenCartao) {
        stripeApiKey= stripeApiKey;
        Map<String, Object> resposta = new HashMap<>();

        try {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("amount", (int) (valor * 100)); // Convertendo para centavos
            parametros.put("currency", "brl");
            parametros.put("source", tokenCartao);
            parametros.put("description", "Pagamento da reserva");

            Charge charge = Charge.create(parametros);
            resposta.put("sucesso", true);
            resposta.put("dados", charge);
        } catch (Exception e) {
            resposta.put("sucesso", false);
            resposta.put("erro", e.getMessage());
        }

        return resposta;
    }

    // CRUD de Pagamento
    @PostMapping("/novo")
    public ResponseEntity<Pagamento> novoPagamento(@RequestBody Pagamento pagamento) {
        Pagamento novoPagamento = pagamentoService.novoPagamento(pagamento);
        return ResponseEntity.ok(novoPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pagamento>> consultarPagamento(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.consultarPagamento(id));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPeloId(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.buscarPagamentoPeloId(id);
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamentoAtualizado) {
        Pagamento pagamento = pagamentoService.atualizarPagamento(id, pagamentoAtualizado);
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirPagamento(@PathVariable Long id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
