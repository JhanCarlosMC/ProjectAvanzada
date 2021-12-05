package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Usuario;
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

@Component
@ViewScoped
public class DetalleUsuarioBean implements Serializable {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Value("#{param['usuario']}")
    private String codigoUsuario;

    @Getter @Setter
    Usuario usuario;

    @PostConstruct
    public void inicializar() throws Exception {
        if(codigoUsuario != null && !codigoUsuario.isEmpty()){
            usuario = usuarioServicio.obtenerUsuario(codigoUsuario);
        }
    }

    public void actualizarUsuario() {
        try {
            usuarioServicio.actualizarUsuario(usuario);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Usuario Actualizado");
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        }
    }

    public void eliminarUsuario(String codigo){
        try {
            usuarioServicio.eliminarUsuario(codigo);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Usuario Eliminado");
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean",facesMessage);
        }
    }
}
