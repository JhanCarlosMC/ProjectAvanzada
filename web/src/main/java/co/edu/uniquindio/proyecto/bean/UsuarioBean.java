package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
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
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter
    @Setter
    private Usuario usuario;

    @Getter
    @Setter
    private List<Ciudad>ciudades;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;

    @Getter @Setter
    private List<Producto> productos;

    @Getter @Setter
    private List<Producto> productosComprados;

    private final UsuarioServicio usuarioServicio;

    private final CiudadServicio ciudadServicio;

    private final ProductoServicio productoServicio;

    public UsuarioBean(UsuarioServicio usuarioServicio, ProductoServicio productoServicio, CiudadServicio ciudadServicio) {
        this.usuarioServicio = usuarioServicio;
        this.productoServicio = productoServicio;
        this.ciudadServicio = ciudadServicio;
    }

    @PostConstruct
    public void inicializar()
    {
        usuario = new Usuario();
        ciudades = ciudadServicio.listarCiudades();

        if(usuarioSesion != null)
        {
            try {
                this.productos = productoServicio.listarProductos(usuarioSesion.getCodigo());
                this.productosComprados = productoServicio.listarProductos(usuarioSesion.getCodigo());
                productoServicio.listarProductos(usuarioSesion.getCodigo()).size();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String registrarUsuario()
    {
        try {
            System.out.println(0);
            usuarioServicio.registrarUsuario(usuario);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        }
        catch (Exception e)
        {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta", "Registro fallido.");
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);

            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        }
        return "index.xhtml?faces-redirect=true";
    }

}
