package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.repositorios.AdministradorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio {

    private final AdministradorRepo administradorRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo) {
        this.administradorRepo = administradorRepo;
    }

    public boolean isAvaible(String email) {
        Optional<Administrador> administrador = administradorRepo.findByEmail(email);
        return administrador.isEmpty();
    }

    @Override
    public Administrador registrarAdministrador(Administrador administrador) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findById(administrador.getCodigo());

        if (buscado.isPresent()) {
            throw new Exception("El codigo de administrador ya existe");
        }
        if (!isAvaible(administrador.getEmail())) {
            throw new Exception("El Email ya se encuentra en uso");
        }
        return administradorRepo.save(administrador);
    }

    @Override
    public Administrador actualizarAdministrador(Administrador administrador) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findById(administrador.getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }
        return administradorRepo.save(administrador);
    }

    @Override
    public void eliminarAdministrador(String codigo) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findById(codigo);

        if (buscado.isEmpty()) {
            throw new Exception("El administrador no existe");
        }
        administradorRepo.deleteById(codigo);
    }

    @Override
    public List<Administrador> listaAdministradores() {
        return administradorRepo.findAll();
    }

    @Override
    public Administrador obtenerAdministrador(String id) {
        return administradorRepo.getById(id);
    }

    @Override
    //Metodo para validar que un administrador este registrado e iniciar sesion en base al email y password
    public Administrador login(String email, String password) throws Exception {
        return administradorRepo.findByEmailAndPassword(email,password).orElseThrow(() -> new Exception("Los datos de autenticacion no son correctos"));
    }

    @Override
    //Metodo para recuperar password segun un email
    public String recuperacionPassword(String email) throws Exception {
        Optional<Administrador> buscado = administradorRepo.findByEmail(email);

        if (buscado.isEmpty()){
            throw new Exception("El email no esta relacionado a ningun administrador");
        }
        return buscado.get().getPassword();
    }
}
