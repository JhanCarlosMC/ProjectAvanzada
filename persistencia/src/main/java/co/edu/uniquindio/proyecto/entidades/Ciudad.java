package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;



@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Ciudad {

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

}
