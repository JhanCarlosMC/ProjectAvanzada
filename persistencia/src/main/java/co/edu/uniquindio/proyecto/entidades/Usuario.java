package co.edu.uniquindio.proyecto.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {

    //Atributos propios de la entidad
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<String>telefonos;

    //Relaciones
    @Column(length = 40)
    private String username;

    @ManyToOne
    //@JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Chat> chats;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Compra> compras;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<Comentario> comentarios;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Producto> productosFavoritos;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    @JsonIgnore
    private List<DetalleSubasta> detalleSubastas;

    //Constructor SuperClase
    public Usuario(String codigo, String nombre, String email, String password) {
        super(codigo, nombre, email, password);
    }
}
