package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Ciudad implements Serializable {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 40, nullable = false)
    private String nombre;

    //--------------------------Relaciones------------------------------------
    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudad")
    private List<Producto> productos;

    //Constructor Completo
    public Ciudad(Integer codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.productos = productos;
    }
}
