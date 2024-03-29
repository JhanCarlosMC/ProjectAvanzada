package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.dto.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.MedioPago;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import co.edu.uniquindio.proyecto.servicios.EmailSenderService;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope("session")
@Component
public class SeguridadBean {

    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String email, password;

    @Getter
    @Setter
    private Usuario usuarioSesion;

    @Autowired
    private UsuarioServicio usuarioServicio;

    private final UsuarioRepo usuarioRepo;


    @Autowired
    private ProductoServicio productoServicio;

    @Getter
    @Setter
    private ArrayList<ProductoCarrito> productosCarrito;

    @Getter
    @Setter
    private int subtotal;

    @Autowired
    private EmailSenderService emailSenderService;

    @Getter @Setter
    private String emailRecuperarContraseña;

    @Getter @Setter
    private String nuevaContraseña;

    public SeguridadBean (UsuarioRepo miURepo)
    {
        this.usuarioRepo = miURepo;
    }

    @PostConstruct
    public void inicializar() {
        this.subtotal = 0;
        this.productosCarrito = new ArrayList<>();

    }


    public String iniciarSesion() {

        if (!email.isEmpty() && !password.isEmpty()) {
            if (email.equals("admin@mail.com")) {
                try {
                    usuarioSesion = usuarioServicio.login(email, password);
                    autenticado = true;
                    return "/administrador/gestionar_usuarios?faces-redirect=true";
                } catch (Exception e) {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                    FacesContext.getCurrentInstance().addMessage("login-bean", fm);
                }

            }
        }

        if (!email.isEmpty() && !password.isEmpty()) {
            try {
                usuarioSesion = usuarioServicio.login(email, password);
                autenticado = true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }
        return null;
    }


    public String cerrarSesion() {
        //autenticado = false;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void agregarAlCarrito(Integer id, int precio, String nombre, String imagen) {
        ProductoCarrito pc = new ProductoCarrito(id, nombre, imagen, precio, 1);
        if (!productosCarrito.contains(pc)) {
            productosCarrito.add(pc);
            subtotal += precio;
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "El producto se agrego al carrito");
            FacesContext.getCurrentInstance().addMessage("add-cart", fm);
        }
    }

    public void eliminarDelCarrito(int indice) {
        subtotal -= productosCarrito.get(indice).getPrecio();
        productosCarrito.remove(indice);
    }

    public void actualizarSubtotal() {
        subtotal = 0;
        for (ProductoCarrito p : productosCarrito) {
            subtotal += p.getPrecio() * p.getUnidades();
        }
    }

    public void comprar() {
        if (usuarioSesion != null && !productosCarrito.isEmpty())
        {
            try {
                productoServicio.comprarProductos(usuarioSesion, productosCarrito, MedioPago.TARJETA);
                productosCarrito.clear();
                subtotal = 0;
                //comprobar que las unidades sean correctas
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Compra realizada con exito");
                FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
            }
        }
    }

    public void usuarioAdministrador()
    {

    }
    public void enviarCorreoContraseña(String email) throws Exception
    {
        Usuario miU = usuarioRepo.findByEmail(email).orElseThrow(() -> new Exception("El email ingresado, no existe"));

        String mensaje = "<h1>Hola, " + miU.getNombre() + "</h1>"
                + "<br/>"
                + "<h2>Recuperar tu contraseña</h2>"
                + "<br/>"
                + "<p>Nickname:" + miU.getUsername()
                + "<br/>"
                + "Para modificar la constraseña, click en el siguente enlace: http://localhost:8080/cambio_contraseña.xhtml"
                + "<br/>"
                + "<br/>"
                + "Atentamente, "
                + "<h3>Unishop</h3>"
                + "</p>";

        emailSenderService.sendSimpleEmail(/*miU.getEmail()*/"juansebastianmedinasanabria@gmail.com", mensaje, "[Recuperar Constraseña]");

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Email enviado con exito.");
        FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
    }
    public void modificarConstraseña() throws Exception
    {
        if(!emailRecuperarContraseña.equals(null) && !nuevaContraseña.equals(null))
        {
            usuarioServicio.recuperarPassword(emailRecuperarContraseña, nuevaContraseña);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Contraseña cambiada con Exito.");
            FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
        }
        else
        {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "Error datos faltantes.");
            FacesContext.getCurrentInstance().addMessage("compra-msj", fm);
        }
    }
}
