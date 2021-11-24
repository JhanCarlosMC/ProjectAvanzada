package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Chat;

import java.util.List;

public interface ChatServicio {

    Chat registrarChat(Chat chat) throws Exception;

    Chat actualizarChat(Chat chat) throws Exception;

    void eliminarChat(String codigo) throws Exception;

    List<Chat> listaChats();

    Chat obtenerChat(String id);
}
