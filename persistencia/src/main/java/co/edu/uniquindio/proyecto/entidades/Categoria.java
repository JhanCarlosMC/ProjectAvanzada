package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Categoria {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 40, nullable = false)
    private String nombre;
}
