package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Compra implements Serializable {

    //Atributos propios de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    @Column(nullable = false)
    private LocalDate fechaCompra;

    @Column(nullable = false, name = "medio_pago")
    private MedioPago medioPago;

    //Relaciones
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "compra")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;

    @ElementCollection
    @Column(nullable = true)
    private List<String> imagenes;

    //Constructor Completo
    public Compra(Integer codigo, LocalDate fechaCompra, MedioPago medioPago)
    {
        this.codigo = codigo;
        this.fechaCompra = fechaCompra;
        this.medioPago = medioPago;
    }
    public String getImagenPrincipal(){
        if (imagenes != null && !imagenes.isEmpty()){
            return imagenes.get(0);
        }
        return "default.png";
    }

}
