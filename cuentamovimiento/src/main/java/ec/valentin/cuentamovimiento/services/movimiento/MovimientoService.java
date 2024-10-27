package ec.valentin.cuentamovimiento.services.movimiento;

import java.util.List;
import ec.valentin.cuentamovimiento.models.MovimientoModel;

public interface MovimientoService {

    public MovimientoModel createMovimiento(MovimientoModel movimientoModel);

    public MovimientoModel updateMovimiento(MovimientoModel movimientoModel);

    public MovimientoModel deleteMovimiento(Long id);

    public MovimientoModel getMovimiento(Long id);

    public List<MovimientoModel> getMovimientos();

}
