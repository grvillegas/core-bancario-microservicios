package com.banco.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banco.cuentas.model.Cuenta;
import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    List<Cuenta> findByClienteId(Long clienteId);
}