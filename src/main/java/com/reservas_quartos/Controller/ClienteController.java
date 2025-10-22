package com.reservas_quartos.Controller;


import  com.reservas_quartos.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reservas_quartos.repository.ClienteRepository;
import com.reservas_quartos.service.ClienteService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired

    private ClienteRepository clienteRepository;

    @PostMapping

    public ResponseEntity<Cliente> CadastrarCliente(@RequestBody Cliente cliente){
        Cliente novoCliente=clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setTelefone(clienteAtualizado.getTelefone());
            Cliente clienteAtualizadoDb = clienteRepository.save(cliente);
            return ResponseEntity.ok().body(clienteAtualizadoDb);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public Optional<Cliente> consultarCliente(@PathVariable Long id){
        return clienteService.consultarCliente(id);
    }


    @GetMapping
    public List<Cliente>obterTodosClientes(){
        return clienteService.obterTodosClientes();
    }

    @GetMapping
    public ResponseEntity<Cliente>buscarClientePeloId(@PathVariable Long id ){
        Cliente cliente =clienteService.buscarClientePeloId(id);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping
    public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Cliente>>buscarClientePeloNome(@PathVariable String nome){
        List<Cliente> clientes=clienteService.buscarClientePeloNome(nome);
        return ResponseEntity .ok(clientes);
    }

}


