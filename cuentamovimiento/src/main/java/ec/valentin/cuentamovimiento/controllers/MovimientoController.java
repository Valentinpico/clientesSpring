package ec.valentin.cuentamovimiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.valentin.cuentamovimiento.models.MovimientoModel;
import ec.valentin.cuentamovimiento.services.movimiento.MovimientoServiceImp;

import java.util.List;

@RestController
public class MovimientoController {

    @Autowired
    private MovimientoServiceImp movimientoService;

    @GetMapping("/movimiento/{movimientoId}")
    public MovimientoModel getMovimiento(@RequestParam Long movimientoId) {
        MovimientoModel movimiento = movimientoService.getMovimiento(movimientoId);
        return movimiento;
    }

    @GetMapping("/movimiento")
    public List<MovimientoModel> getMovimientos() {
        List<MovimientoModel> movimientos = movimientoService.getMovimientos();

        movimientos.forEach(movimiento -> {

            movimiento.getCuenta().setMovimientos(null);
        });
        return movimientos;
    }

    @PostMapping("/movimiento")
    public MovimientoModel createMovimiento(@RequestBody MovimientoModel movimiento) {
        MovimientoModel newMovimiento = movimientoService.createMovimiento(movimiento);
        return newMovimiento;
    }

    @PutMapping("/movimiento")
    public MovimientoModel updateMovimiento(MovimientoModel movimiento) {
        MovimientoModel newMovimiento = movimientoService.updateMovimiento(movimiento);
        return newMovimiento;
    }

    @DeleteMapping("/movimiento/{movimientoId}")
    public void deleteMovimiento(@RequestParam Long movimientoId) {
        movimientoService.deleteMovimiento(movimientoId);
    }

}
