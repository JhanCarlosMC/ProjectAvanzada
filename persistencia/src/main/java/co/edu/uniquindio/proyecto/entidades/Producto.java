package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
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

    @Min(0) @Max(5)
    private int descuento;

    //Falta definir el tipo de dato de fecha
    @Column(name = "fecha_limite")
    private Date fechaLimite;

    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "producto")
    private List<Subasta> subastas;
    @ManyToMany
    private List<Categoria> categorias;
    @ManyToMany
    private List<Usuario> usuarios;
}

