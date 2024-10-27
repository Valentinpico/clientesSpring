
package ec.valentin.cuentamovimiento.repository.movimiento;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.valentin.cuentamovimiento.models.MovimientoModel;

public interface MovimientoRepo extends JpaRepository<MovimientoModel, Long> {

}
