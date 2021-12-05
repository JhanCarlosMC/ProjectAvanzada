package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<Producto>productos;

    @Getter @Setter
    private List<Usuario>usuarios;

    @PostConstruct
    public void inicializar() throws Exception {
        this.productos = productoServicio.listarTodosProductos();
        this.usuarios = usuarioServicio.listarUsuarios();
    }


    public String irADetalle(String id){
        return "/detalle_producto?faces-redirect=true&amp;producto="+id;
    }

    public String irADetalleUsuario(String codigo){
        return "/administrador/detalle_usuario?faces-redirect=true&amp;usuario="+codigo;
    }
}
