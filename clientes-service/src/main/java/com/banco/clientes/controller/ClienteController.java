package com.banco.clientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.banco.clientes.model.Cliente;
import com.banco.clientes.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired private ClienteService clienteService;

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crear(cliente);
    }

    @GetMapping("/{id}")
    public Cliente consultar(@PathVariable Long id) {
        return clienteService.consultar(id);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}