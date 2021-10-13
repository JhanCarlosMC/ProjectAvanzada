package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Compra {

    //--------------------------Atributos propios de la entidad------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    private Date fechaCompra;
    private MedioPago medioPago;
}
