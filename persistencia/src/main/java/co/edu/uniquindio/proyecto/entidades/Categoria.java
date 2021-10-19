package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
<<<<<<< HEAD
import java.sql.SQLOutput;
=======
import java.io.Serializable;
>>>>>>> c82fe0f6f47b2754b66d741e99dc9a6f4bf60204
import java.util.List;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Categoria implements Serializable {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 40, nullable = false)
    private String nombre;

    //--------------------------Relaciones------------------------------------
    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    private List<Producto> productos;

}
