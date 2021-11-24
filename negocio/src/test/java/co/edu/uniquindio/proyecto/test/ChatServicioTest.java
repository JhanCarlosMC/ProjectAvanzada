package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Chat;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ChatServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ChatServicioTest {

    @Autowired
    private ChatServicio chatServicio;

    @Test
    public void ingresarChatTest() {
        Producto producto = Producto.builder()
                .codigo("1").nombre("mouse gamer").unidades(5)
                .descripcion("mouse para juegos").precio(15000)
                .descuento(5)
                .fechaLimite(LocalDate.of(2021,10,20)).build();

        Usuario newUsuario = new Usuario("4", "Jhan", "Jcmc@gmail.com", "100232");

        Chat chat = new Chat("1", newUsuario, producto);

        try {
            Chat respuesta = chatServicio.registrarChat(chat);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarChatTest() throws Exception {
        Producto producto = Producto.builder()
                .codigo("1").nombre("mouse gamer").unidades(5)
                .descripcion("mouse para juegos").precio(15000)
                .descuento(5)
                .fechaLimite(LocalDate.of(2021,10,20)).build();

        Usuario newUsuario = new Usuario("4", "Jhan", "Jcmc@gmail.com", "100232");

        Chat chat = new Chat("1", newUsuario, producto);
        Chat respuesta = chatServicio.registrarChat(chat);

        Chat updateChat = chatServicio.obtenerChat("1");
        updateChat.setCodigo("12");

        Chat modificado = chatServicio.actualizarChat(updateChat);
        Assertions.assertEquals("12", modificado.getCodigo());
    }

    @Test
    public void eliminarChatTest() throws Exception {
        Producto producto = Producto.builder()
                .codigo("1").nombre("mouse gamer").unidades(5)
                .descripcion("mouse para juegos").precio(15000)
                .descuento(5)
                .fechaLimite(LocalDate.of(2021,10,20)).build();

        Usuario newUsuario = new Usuario("4", "Jhan", "Jcmc@gmail.com", "100232");

        Chat chat = new Chat("1", newUsuario, producto);
        Chat respuesta = chatServicio.registrarChat(chat);

        chatServicio.eliminarChat("1");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaChatsTest() throws Exception {
        Producto producto = Producto.builder()
                .codigo("1").nombre("mouse gamer").unidades(5)
                .descripcion("mouse para juegos").precio(15000)
                .descuento(5)
                .fechaLimite(LocalDate.of(2021,10,20)).build();

        Usuario newUsuario = new Usuario("4", "Jhan", "Jcmc@gmail.com", "100232");

        Chat chat = new Chat("1", newUsuario, producto);
        Chat respuesta = chatServicio.registrarChat(chat);

        List<Chat> listaChats = chatServicio.listaChats();
        listaChats.forEach(System.out::println);
    }
}
