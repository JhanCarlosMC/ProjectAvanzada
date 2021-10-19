package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class Mensaje {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 255, nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String emisor;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    private Chat chat;

    public Mensaje(String codigo, String mensaje, String emisor, LocalDate fecha) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.fecha = fecha;
    }
}
