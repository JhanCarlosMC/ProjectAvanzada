package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class DetalleSubasta implements Serializable {

    //Atributos propios de la entidad
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Min(0)
    @Column(nullable = false)
    private int valor;

    @Column(nullable = false)
    private LocalDate fechaSubasta;

    //Relaciones
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subasta subasta;


}
