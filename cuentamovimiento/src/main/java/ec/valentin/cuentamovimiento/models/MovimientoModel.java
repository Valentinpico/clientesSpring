package ec.valentin.cuentamovimiento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimiento")
public class MovimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimientoId;

    //defeto de la fecha actual
    private LocalDateTime fecha;
    private String tipoMovimiento;
    private Integer valor;
    private Integer saldo;

    // Relación con cuenta
    @ManyToOne
    @JoinColumn(name = "numeroCuenta", nullable = false)
    private CuentaModel cuenta;

}
