package ec.valentin.cuentamovimiento.repository.cuenta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.valentin.cuentamovimiento.models.CuentaModel;

public interface CuentaRepository extends JpaRepository<CuentaModel, String> {

    List<CuentaModel> findByClienteId(Long clienteId);

}
