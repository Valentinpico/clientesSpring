package ec.valentin.cuentamovimiento.services.cuenta;

import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import ec.valentin.cuentamovimiento.models.ClienteDTO;
import ec.valentin.cuentamovimiento.models.CuentaModel;
import ec.valentin.cuentamovimiento.models.MovimientoModel;
import ec.valentin.cuentamovimiento.models.ReporteDTO;
import ec.valentin.cuentamovimiento.repository.cuenta.CuentaRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CuentaServiceImp implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public CuentaModel createCuenta(CuentaModel cuentaModel) {
        CuentaModel cuenta = cuentaRepository.save(cuentaModel);

        return cuenta;
    };

    public CuentaModel updateCuenta(CuentaModel cuentaModel, String id) {
        CuentaModel cuenta = cuentaRepository.findById(id).get();
        cuenta.setTipoCuenta(cuentaModel.getTipoCuenta());
        cuenta.setSaldoInicial(cuentaModel.getSaldoInicial());
        cuenta.setEstado(cuentaModel.getEstado());
        cuenta.setClienteId(cuentaModel.getClienteId());
        cuenta.setMovimientos(cuentaModel.getMovimientos());
        cuentaRepository.save(cuenta);
        return cuenta;
    };

    public CuentaModel deleteCuenta(String id) {
        cuentaRepository.deleteById(id);
        return null;
    };

    public CuentaModel getCuenta(String id) {
        CuentaModel cuenta = cuentaRepository.findById(id).get();
        return cuenta;
    };

    public List<CuentaModel> getCuentas() {
        List<CuentaModel> cuentas = cuentaRepository.findAll();
        return cuentas;
    };

    public List<ReporteDTO> obtenerReporte(ChronoLocalDateTime<?> fechaInicio, ChronoLocalDateTime<?> fechaFin,
            Long clienteId) {

        ClienteDTO cliente = obtenerClientePorId(clienteId).block();

        List<CuentaModel> cuenta = cuentaRepository.findByClienteId(clienteId);

        List<MovimientoModel> movimientosFiltrados = cuenta.stream()
                .flatMap(c -> c.getMovimientos().stream())
                .filter(movimiento -> movimiento.getFecha().isAfter(fechaInicio)
                        && movimiento.getFecha().isBefore(fechaFin))
                .collect(Collectors.toList());

        return movimientosFiltrados.stream().map(movimiento -> {
            ReporteDTO reporte = new ReporteDTO();
            reporte.setFecha(movimiento.getFecha());
            reporte.setCliente(cliente.getNombre());
            reporte.setNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
            reporte.setTipo(movimiento.getCuenta().getTipoCuenta());
            reporte.setSaldoInicial(movimiento.getCuenta().getSaldoInicial());
            reporte.setEstado(movimiento.getCuenta().getEstado());
            reporte.setMovimiento(movimiento.getValor());
            reporte.setSaldoDisponible(movimiento.getSaldo());
            return reporte;
        }).collect(Collectors.toList());
    }

    @Override
    public Mono<ClienteDTO> obtenerClientePorId(Long clienteId) {
        String clienteUrl = "http://localhost:8081/cliente/" + clienteId;

        return webClientBuilder.build()
                .get()
                .uri(clienteUrl)
                .retrieve()
                .bodyToMono(ClienteDTO.class);
    }
}
