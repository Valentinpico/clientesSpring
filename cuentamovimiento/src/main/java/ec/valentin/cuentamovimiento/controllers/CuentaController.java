package ec.valentin.cuentamovimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ec.valentin.cuentamovimiento.models.CuentaModel;
import ec.valentin.cuentamovimiento.models.ReporteDTO;
import ec.valentin.cuentamovimiento.services.cuenta.CuentaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalDateTime;

import java.util.List;

@RestController
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/cuenta/{numeroCuenta}")
    public CuentaModel getCuenta(@PathVariable String numeroCuenta) {
        CuentaModel cuenta = cuentaService.getCuenta(numeroCuenta);
        return cuenta;
    }

    @PostMapping("/cuenta")
    public CuentaModel createCuenta(@RequestBody CuentaModel cuenta) {
        CuentaModel newCuenta = cuentaService.createCuenta(cuenta);
        return newCuenta;
    }

    @PutMapping("/cuenta/{numeroCuenta}")
    public CuentaModel updateCuenta(@RequestBody CuentaModel cuenta, @PathVariable String numeroCuenta) {
        CuentaModel newCuenta = cuentaService.updateCuenta(cuenta, numeroCuenta);
        return newCuenta;
    }

    @GetMapping("/cuenta")
    public List<CuentaModel> getCuentas() {
        List<CuentaModel> cuentas = cuentaService.getCuentas();
        cuentas.forEach(cuenta -> {
            cuenta.getMovimientos().forEach(movimiento -> {
                movimiento.setCuenta(null);
            });
        });
        return cuentas;
    }

    @DeleteMapping("/cuenta/{numeroCuenta}")
    public void deleteCuenta(@PathVariable String numeroCuenta) {
        cuentaService.deleteCuenta(numeroCuenta);
    }

    @GetMapping("/reporte")
    public List<ReporteDTO> obtenerReporte(
            @RequestParam() LocalDateTime fechaInicio,
            @RequestParam() LocalDateTime fechaFin,
            @RequestParam() Long clienteId) {
        return cuentaService.obtenerReporte(fechaInicio, fechaFin, clienteId);
    }

}
