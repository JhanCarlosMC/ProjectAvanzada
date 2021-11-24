package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;

    public ComentarioServicioImpl(ComentarioRepo comentarioRepo) {
        this.comentarioRepo = comentarioRepo;
    }

    @Override
    public Comentario registrarComentario(Comentario comentario) throws Exception {
        return comentarioRepo.save(comentario);
    }

    @Override
    public Comentario actualzarComentario(Comentario comentario) throws Exception {
        Optional<Comentario> buscado = comentarioRepo.findById(comentario.getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("El comentario no existe");
        }

        return comentarioRepo.save(comentario);
    }

    @Override
    public void eliminarComentario(String codigo) throws Exception {
        Optional<Comentario> buscado = comentarioRepo.findById(codigo);

        if (buscado.isEmpty()) {
            throw new Exception("El comentario no existe");
        }

        comentarioRepo.deleteById(codigo);
    }

    @Override
    public List<Comentario> listaComentarios() {
        return comentarioRepo.findAll();
    }

    @Override
    public Comentario obtenerComentario(String id) {
        return comentarioRepo.getById(id);
    }
}
