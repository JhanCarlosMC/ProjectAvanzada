package co.edu.uniquindio.proyecto.servicios;

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

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario>buscado = usuarioRepo.findById(u.getCodigo());
        if(buscado.isPresent()){
            throw new Exception("El código ya existe");
        }
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
    public Usuario login(String email, String password) throws Exception {
        return usuarioRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception(""));
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        return usuarioRepo.findByCodigo(codigo).orElseThrow(() -> new Exception("El usuario no Existe"));
    }

    @Override
    public Usuario iniciarSesion(String email, String password) throws Exception {
        return usuarioRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Los datos de autenticación son incorrectos"));
    }

    @Override
    public String recuperarPassword(String email) throws Exception {
        return null;
    }

    @Override
    public void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception
    {
        //if(isFavorito(producto, usuario) == false)

        System.out.println("Entra 1");
        System.out.println("Usuario: "+usuario.getCodigo());
        System.out.println("Producto: "+producto.getCodigo());

        List<Producto> listaFavoritos = usuario.getProductosFavoritos();

        for (int i = 0; i<listaFavoritos.size(); i++)
        {
            System.out.println("Entra 2");
            Producto miP = listaFavoritos.get(i);
            System.out.println("Producto "+i+": "+miP);
        }

        listaFavoritos.add(producto);
        usuario.setProductosFavoritos(listaFavoritos);

        System.out.println("Usuario: "+usuario.toString());

        actualizarUsuario(usuario);

    }
    @Override
    public boolean isFavorito(Producto producto, Usuario usuario)
    {
        boolean isFavorito = false;
        List<Producto> listaProductos = usuario.getProductos();
        for( int i = 0; i< listaProductos.size(); i++)
        {
            if(usuario.getProductosFavoritos().get(i).equals(producto))
            {
                isFavorito = true;
            }
        }
        return isFavorito;
    }

    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception
    {
        if(isFavorito(producto, usuario))
        {
            usuario.getProductosFavoritos().remove(producto);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El producto a eliminar no existe en la lista.");
        }
    }
}
