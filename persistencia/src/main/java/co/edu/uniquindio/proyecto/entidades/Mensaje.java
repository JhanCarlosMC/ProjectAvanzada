package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
=======
import javax.persistence.*;
>>>>>>> c82fe0f6f47b2754b66d741e99dc9a6f4bf60204
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

<<<<<<< HEAD
=======
    //Definir fomato de la fecha
>>>>>>> c82fe0f6f47b2754b66d741e99dc9a6f4bf60204
    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Chat chat;

    public Mensaje(String codigo, String mensaje, String emisor, LocalDate fecha) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.emisor = emisor;
        this.fecha = fecha;
    }
}
