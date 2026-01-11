package com.banco.cuentas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.cuentas.model.Cuenta;
import com.banco.cuentas.repository.CuentaRepository;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta crear(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta consultar(Long id) {
        return cuentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id: " + id));
    }

    public List<Cuenta> listarPorCliente(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    public Cuenta actualizar(Long id, Cuenta cuentaActualizada) {
        Cuenta cuenta = consultar(id);
        cuenta.setTipo(cuentaActualizada.getTipo());
        cuenta.setEstado(cuentaActualizada.getEstado());
        cuenta.setSaldo(cuentaActualizada.getSaldo());
        return cuentaRepository.save(cuenta);
    }

    public void eliminar(Long id) {
        cuentaRepository.deleteById(id);
    }
}