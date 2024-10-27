package ec.valentin.cuentamovimiento.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class CuentaModel {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String numeroCuenta;

    private String tipoCuenta;
    private Integer saldoInicial;
    private Boolean estado;
    private Long clienteId;

    // Relación con movimientos
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovimientoModel> movimientos;
}
