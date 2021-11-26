package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.repositorios.MensajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServicioImpl implements MensajeServicio{

    private final MensajeRepo mensajeRepo;

    public MensajeServicioImpl(MensajeRepo mensajeRepo) {
        this.mensajeRepo = mensajeRepo;
    }

    @Override
    public Mensaje registrarMensaje(Mensaje mensaje) throws Exception {
        Optional<Mensaje> buscado = mensajeRepo.findById(mensaje.getCodigo());

        if (buscado.isPresent()){
            throw new Exception("El mensaje ya existe");
        }
        return mensajeRepo.save(mensaje);
    }

    @Override
    public Mensaje actualizarMensaje(Mensaje mensaje) throws Exception {
        Optional<Mensaje> buscado = mensajeRepo.findById(mensaje.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("El mensaje no existe");
        }
        return mensajeRepo.save(mensaje);
    }

    @Override
    public void eliminarMensaje(String codigo) throws Exception {
        Optional<Mensaje> buscado = mensajeRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El mensaje no existe");
        }
        mensajeRepo.deleteById(codigo);
    }

    @Override
    public List<Mensaje> listaMensajes() {
        return mensajeRepo.findAll();
    }

    @Override
    public Mensaje obtenerMensaje(String id) {
        return mensajeRepo.getById(id);
    }
}