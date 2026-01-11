package com.banco.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banco.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNumeroDocumento(String numeroDocumento);
}