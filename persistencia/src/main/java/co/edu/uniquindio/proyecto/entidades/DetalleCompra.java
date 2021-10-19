package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class DetalleCompra implements Serializable {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Min(0)
    @Column(nullable = false)
    private int unidades;

    @Min(0)
    @Column(nullable = false, name = "precio_producto")
    private int precioProducto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;

}
