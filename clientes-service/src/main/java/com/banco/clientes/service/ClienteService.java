package com.banco.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.clientes.model.Cliente;
import com.banco.clientes.repository.ClienteRepository;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente consultar(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Cliente cliente = consultar(id);
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setTipoDocumento(clienteActualizado.getTipoDocumento());
        cliente.setNumeroDocumento(clienteActualizado.getNumeroDocumento());
        cliente.setEmail(clienteActualizado.getEmail());
        cliente.setTelefono(clienteActualizado.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}