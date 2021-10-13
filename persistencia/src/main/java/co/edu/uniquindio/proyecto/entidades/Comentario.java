package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Comentario {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 255, nullable = false)
    private String mensaje;

    @Column(length = 255, nullable = false)
    private String respuesta;

    //Definir formato de fecha
    @Column(name = "fecha_comentario")
    private Date fechaComentario;

    @Min(0) @Max(5)
    @Column(nullable = false)
    private int calificacion;

}
