package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class PerfilBean implements Serializable
{

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Getter
    @Setter
    private List<Producto> listaProductos;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private Usuario usuarioActual;

    @PostConstruct
    public void inicializar(){
        this.usuarioActual=usuarioSesion;
        this.listaProductos = productoServicio.listarProductos(usuarioSesion.getCodigo());
    }

    public String irAModificarProducto(String codigo)
    {
        return "/usuario/modificar_producto?faces-redirect=true&amp;modificar="+codigo;
    }


}
