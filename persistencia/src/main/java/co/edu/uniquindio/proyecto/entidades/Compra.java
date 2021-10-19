package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Compra implements Serializable {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    //Definir formato de la fecha
    private LocalDate fechaCompra;

    @Column(nullable = false, name = "medio_pago")
    private MedioPago medioPago;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalleCompras;


    //Constructor Completo
    public Compra(String codigo, Date fechaCompra, MedioPago medioPago)
    {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.medioPago = medioPago;
    }
}
