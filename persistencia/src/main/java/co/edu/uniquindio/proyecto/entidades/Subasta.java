package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
<<<<<<< HEAD
import java.io.Serializable;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Subasta implements Serializable {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Producto producto;
    @OneToMany(mappedBy = "subasta")
    @ToString.Exclude
    private List<DetalleSubasta> detalleSubastas;

    public Subasta(String codigo, LocalDate fechaLimite) {
        this.codigo = codigo;
        this.fechaLimite = fechaLimite;
    }
}
