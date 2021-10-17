package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Usuario extends Persona{

    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "usuario")
    private List<Chat> chats;
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @ManyToMany(mappedBy = "usuarios")
    private List<Producto> productoUsuarios;
    @OneToMany(mappedBy = "usuario")
    private List<DetalleSubasta> detalleSubastas;

}
