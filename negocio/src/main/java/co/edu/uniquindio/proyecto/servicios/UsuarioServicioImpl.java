package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        return buscarUsuario(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        return buscarUsuario(u);
    }

    private Usuario buscarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodigo());
        if(buscado.isPresent()){
            throw new Exception("El email del usuario ya existe");
        }

        buscado = buscarPorEmail(u.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El email del usuario ya existe");
        }

//        buscado = usuarioRepo.findByEmail(u.getUsername());
        if(buscado.isPresent()){
            throw new Exception("El username ya existe");
        }

        return usuarioRepo.save(u);
    }

    private Optional<Usuario>buscarPorEmail(String email){
        return usuarioRepo.findByEmail(email);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El email del usuario no existe");
        }
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
    public String recuperarPassword(String email) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByEmail(email);

        if (buscado.isEmpty()){
            throw new Exception("El email no esta relacionado con ningun usuario");
        }
        return buscado.get().getPassword();
    }
}