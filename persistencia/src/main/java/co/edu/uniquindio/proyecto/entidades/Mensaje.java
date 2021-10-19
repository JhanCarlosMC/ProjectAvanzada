package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.time.LocalDate;

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


    //Definir fomato de la fecha
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
