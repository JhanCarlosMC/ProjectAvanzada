package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Comentario;
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class DetalleProductoBean implements Serializable {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Value("#{param['producto']}")
    private String codigoProducto;

    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private Comentario nuevoComentario;

    @Getter @Setter
    private List<Comentario> comentarios;

    @Getter @Setter
    private List<Producto> listaProductoFavoritos;

    @Getter @Setter
    private Integer calificacionPromedio;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @PostConstruct
    public void inicializar(){
        nuevoComentario = new Comentario();
        listaProductoFavoritos = new ArrayList<>();
        if(codigoProducto != null && !codigoProducto.isEmpty()){
            Integer codigo = Integer.parseInt(codigoProducto);
            producto = productoServicio.obtenerProducto(codigo);
            this.comentarios = producto.getComentarios();
        }
    }

    public void crearComentario(){
        try {
            if(usuarioSesion != null){
                nuevoComentario.setProducto(producto);
                nuevoComentario.setUsuario(usuarioSesion);
                productoServicio.comentarProducto(nuevoComentario);

                this.comentarios.add(nuevoComentario);
                nuevoComentario = new Comentario();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void guardarListProductosFavoritos(Integer codigo)
    {
        try {
            producto  = productoServicio.obtenerProducto(codigo);

            if(listaProductoFavoritos.contains(producto) == false)
            {
                listaProductoFavoritos.add(producto);
                usuarioSesion.setProductosFavoritos(listaProductoFavoritos);
                usuarioServicio.guardarProductoFavoritos(usuarioSesion);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "¡Producto Favorito!");
                FacesContext.getCurrentInstance().addMessage("add-fav", fm);
            }else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "El producto ya esta en favoritos.");
                FacesContext.getCurrentInstance().addMessage("add-fav", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error",e.getMessage());
            FacesContext.getCurrentInstance().addMessage("add-fav",fm);
        }
    }
}
