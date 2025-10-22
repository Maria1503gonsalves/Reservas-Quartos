package com.reservas_quartos.service;

import com.reservas_quartos.Entity.Cliente;
import com.reservas_quartos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> consultarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePeloId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarClientePeloNome(String nome) {
        return clienteRepository.findByNome(nome);
    }
}
