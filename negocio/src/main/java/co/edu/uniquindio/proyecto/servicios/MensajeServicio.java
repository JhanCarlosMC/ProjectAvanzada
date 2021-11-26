package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Mensaje;

import java.util.List;

public interface MensajeServicio {

    Mensaje registrarMensaje(Mensaje mensaje) throws Exception;

    Mensaje actualizarMensaje(Mensaje mensaje) throws Exception;

    void eliminarMensaje(String codigo) throws Exception;

    List<Mensaje> listaMensajes();

    Mensaje obtenerMensaje(String id);
}
