package ec.valentin.cuentamovimiento.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReporteDTO {
    private LocalDateTime fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private Integer saldoInicial;
    private boolean estado;
    private Integer movimiento;
    private Integer saldoDisponible;
}
