package ec.valentin.cuentamovimiento.services.movimiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import ec.valentin.cuentamovimiento.models.CuentaModel;
import ec.valentin.cuentamovimiento.models.MovimientoModel;
import ec.valentin.cuentamovimiento.repository.cuenta.CuentaRepository;
import ec.valentin.cuentamovimiento.repository.movimiento.MovimientoRepo;
import java.time.LocalDateTime;

@Service
public class MovimientoServiceImp implements MovimientoService {

    @Autowired
    private MovimientoRepo movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    public MovimientoModel createMovimiento(MovimientoModel movimientoModel) {

        movimientoModel.setFecha(LocalDateTime.now());

        CuentaModel cuenta = cuentaRepository.findById(movimientoModel.getCuenta().getNumeroCuenta()).get();

        int nuevoSaldo = 0;

        nuevoSaldo = cuenta.getSaldoInicial() + movimientoModel.getValor();

        if (movimientoModel.getTipoMovimiento().equals("retiro")) {
            if (cuenta.getSaldoInicial() >= movimientoModel.getValor()) {
                nuevoSaldo = cuenta.getSaldoInicial() - movimientoModel.getValor();
            } else {
                throw new RuntimeException("Saldo no disponible");
            }
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        movimientoModel.setSaldo(nuevoSaldo);

        cuentaRepository.save(cuenta);

        return movimientoRepository.save(movimientoModel);

    };

    public MovimientoModel updateMovimiento(MovimientoModel movimientoModel) {
        MovimientoModel movimiento = movimientoRepository.save(movimientoModel);
        return movimiento;
    };

    public MovimientoModel deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
        return null;
    };

    public MovimientoModel getMovimiento(Long id) {
        MovimientoModel movimiento = movimientoRepository.findById(id).get();
        return movimiento;
    };

    public List<MovimientoModel> getMovimientos() {

        List<MovimientoModel> movimientos = movimientoRepository.findAll();
        return movimientos;
    };

}
