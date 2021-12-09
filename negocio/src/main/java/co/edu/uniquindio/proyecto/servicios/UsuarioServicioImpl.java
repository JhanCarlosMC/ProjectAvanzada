package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final UsuarioRepo usuarioRepo;
    @Autowired
    private EmailSenderService miEmail;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception
    {
        Optional<Usuario>buscado = usuarioRepo.findById(u.getCodigo());
        if(buscado.isPresent())
        {
            throw new Exception("El código ya existe");
        }
        String mensaje = "<h2>Hola, " + u.getNombre() + "</h2>"
                + "<br/>"
                + "<p>Usuario agregado correctamente."
                + "<br/>"
                + "Nickname:" + u.getUsername()
                + "<br/>"
                + "Contraseña: ********"
                + "<br/>"
                + "<br/>"
                + "Atentamente, "
                + "<h3>Unishop</h3>"
                + "</p>";
        miEmail.sendSimpleEmail(u.getEmail(), mensaje, "[Usuario Creado]");
        System.out.println("Creado.");
        return usuarioRepo.save(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        return usuarioRepo.save(u);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        usuarioRepo.deleteById(codigo);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario login(String email, String password) throws Exception
    {
        return usuarioRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception(""));
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        return usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new Exception("El usuario no Existe"));
    }

    @Override
    public Usuario iniciarSesion(String email, String password) throws Exception
    {
        Usuario miU =  usuarioRepo.findByEmailAndPassword(email, password).orElseThrow(() -> new Exception("Los datos son incorrectos, intentelo nuevamente."));

        if(miU != null)
        {
            return miU;
        }
        else
        {
            throw new Exception("El usuario no existe.");
        }
    }

    @Override
    public void recuperarPassword(String email, String nuevaContraseña) throws Exception
    {

        Usuario miU = usuarioRepo.findByEmail(email).orElseThrow(()-> new Exception("El email del usuario no existe."));
        if(miU != null)
        {

            miU.setPassword(nuevaContraseña);


            usuarioRepo.save(miU);
        }

    }

    @Override
    public void guardarProductoFavoritos(Usuario usuario) throws Exception
    {
        usuarioRepo.save(usuario);
    }
    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception
    {
        if(usuario.getProductosFavoritos().contains(producto))
        {
            usuario.getProductosFavoritos().remove(producto);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El producto a eliminar no existe en la lista.");
        }
    }

    @Override
    public List<Compra> listarUsuarios(String codigo) throws Exception {
        return usuarioRepo.findByCodigo(codigo).orElseThrow(()-> new Exception("")).getCompras();
    }

}
