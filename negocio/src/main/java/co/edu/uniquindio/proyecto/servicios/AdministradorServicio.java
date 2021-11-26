package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Administrador;

import java.util.List;

public interface AdministradorServicio {

    Administrador registrarAdministrador(Administrador administrador) throws Exception;

    Administrador actualizarAdministrador(Administrador administrador) throws Exception;

    void eliminarAdministrador(String codigo) throws Exception;

    List<Administrador> listaAdministradores();

    Administrador obtenerAdministrador(String id);

    Administrador login(String email, String password);

    String recuperacionPassword(String emial);


}
