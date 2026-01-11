package com.banco.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.banco.cuentas.model.Cuenta;
import com.banco.cuentas.service.CuentaService;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired private CuentaService cuentaService;

    @PostMapping
    public Cuenta crear(@RequestBody Cuenta cuenta) {
        return cuentaService.crear(cuenta);
    }

    @GetMapping("/{id}")
    public Cuenta consultar(@PathVariable Long id) {
        return cuentaService.consultar(id);
    }

    @GetMapping
    public List<Cuenta> listarPorCliente(@RequestParam Long clienteId) {
        return cuentaService.listarPorCliente(clienteId);
    }

    @PutMapping("/{id}")
    public Cuenta actualizar(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.actualizar(id, cuenta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cuentaService.eliminar(id);
    }
}