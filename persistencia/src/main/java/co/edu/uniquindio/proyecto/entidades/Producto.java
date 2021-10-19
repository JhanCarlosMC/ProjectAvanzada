package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Producto {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Min(0)
    @Column(nullable = false)
    private int unidades;

    @Column(length = 255, nullable = false)
    private String descripcion;

    @Min(0)
    @Column(nullable = false)
    private int precio;

    @Min(0)
    private int descuento;

    //Falta definir el tipo de dato de fecha
    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> numTelefonos;
    //--------------------------Relaciones------------------------------------
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Subasta> subastas;

    @ManyToMany
    @ToString.Exclude
    private List<Categoria> categorias;

    @ManyToMany
    @ToString.Exclude
    private List<Usuario> usuarios;
}

