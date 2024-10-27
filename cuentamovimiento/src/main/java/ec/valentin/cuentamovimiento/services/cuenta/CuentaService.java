package ec.valentin.cuentamovimiento.services.cuenta;

import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

import ec.valentin.cuentamovimiento.models.ClienteDTO;
import ec.valentin.cuentamovimiento.models.CuentaModel;
import ec.valentin.cuentamovimiento.models.ReporteDTO;
import reactor.core.publisher.Mono;

public interface CuentaService {

    public CuentaModel createCuenta(CuentaModel cuentaModel);

    public CuentaModel updateCuenta(CuentaModel cuentaModel, String id);

    public CuentaModel deleteCuenta(String id);

    public CuentaModel getCuenta(String id);

    public List<CuentaModel> getCuentas();

    public List<ReporteDTO> obtenerReporte(ChronoLocalDateTime<?> fechaInicio, ChronoLocalDateTime<?> fechaFin,
            Long clienteId);

    Mono<ClienteDTO> obtenerClientePorId(Long clienteId);
}