package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {

    Comentario registrarComentario(Comentario comentario) throws Exception;

    Comentario actualzarComentario(Comentario comentario) throws Exception;

    void eliminarComentario(String codigo) throws Exception;

    List<Comentario> listaComentarios();
}
