package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Producto implements Serializable {

    //Atributos propios de la entidad
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(name = "nombre_publicacion", length = 50, nullable = false)
    private String nombrePublicacion;

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

    @Column(name = "fecha_limite", nullable = false)
    private LocalDate fechaLimite;

    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> imagenes;

    //Relaciones
    @ManyToOne
//    @JoinColumn(nullable = false)
    private Usuario usuario;

    @ManyToOne
//    @JoinColumn(nullable = false)
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

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Chat> chat;

    @ManyToMany(mappedBy = "productosFavoritos")
    @ToString.Exclude
    private List<Usuario> favoritos;

    @ManyToMany
    @ToString.Exclude
    private List<Usuario> usuarios;

    //Constructor
    @Builder
    public Producto( String nombre, int unidades, String descripcion, int precio, int descuento, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.fechaLimite = fechaLimite;
    }
}

