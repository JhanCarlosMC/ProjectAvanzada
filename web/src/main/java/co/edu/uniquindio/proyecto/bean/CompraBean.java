package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class CompraBean
{
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter
    @Setter
    private List<Compra> listaCompras;

    @Value("#{seguridadBean.usuarioSesion}")
    private Usuario usuarioSesion;



    @PostConstruct
    public void inicializar(){

        try {
            this.listaCompras = usuarioServicio.listarUsuarios(usuarioSesion.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String irADetalleCompra(String codigo){
        return "/usuario/detalle_compra?faces-redirect=true&amp;compra="+codigo;
    }
}
