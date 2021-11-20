package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.repositorios.ChatRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServicioImpl implements ChatServicio{

    private final ChatRepo chatRepo;

    public ChatServicioImpl(ChatRepo chatRepo) {
        this.chatRepo = chatRepo;
    }

    @Override
    public Chat registrarChat(Chat chat) throws Exception {
        return chatRepo.save(chat);
    }

    @Override
    public Chat actualizarChat(Chat chat) throws Exception {
        Optional<Chat> buscado = chatRepo.findById(chat.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("El chat no existe");
        }
        return chatRepo.save(chat);
    }

    @Override
    public void eliminarChat(String codigo) throws Exception {
        Optional<Chat> buscado = chatRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El chat no existe");
        }

        chatRepo.deleteById(codigo);
    }

    @Override
    public List<Chat> listaChats() {
        return chatRepo.findAll();
    }
}
