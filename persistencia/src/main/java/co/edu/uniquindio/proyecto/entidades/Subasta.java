package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Subasta {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    //Falta definir el tipo de dato de fecha
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    @OneToMany(mappedBy = "subasta")
    private List<DetalleSubasta> detalleSubastas;
}
