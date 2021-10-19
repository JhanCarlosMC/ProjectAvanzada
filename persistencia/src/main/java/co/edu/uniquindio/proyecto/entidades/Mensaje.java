package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
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
}
