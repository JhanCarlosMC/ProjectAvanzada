package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.servicios.ComentarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ComentarioServicioTest {

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Test
    public void ingresarComentario() {
        Comentario miCt = new Comentario(0, "Mensaje Prueba", "Respuesta Prueba", LocalDate.of(2018, 10, 30), 5);

        try {
            Comentario respuesta = comentarioServicio.registrarComentario(miCt);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarComentarioTest() throws Exception {
        Comentario miCt = new Comentario(0, "Mensaje Prueba", "Respuesta Prueba", LocalDate.of(2018, 10, 30), 5);
        comentarioServicio.registrarComentario(miCt);

        Comentario updateComent = comentarioServicio.obtenerComentario(0);
        updateComent.setMensaje("Mensaje remplazado");

        Comentario modificado = comentarioServicio.actualzarComentario(updateComent);
        Assertions.assertEquals("Mensaje remplazado", modificado.getMensaje());
    }

    @Test
    public void eliminarComentarioTest() throws Exception {
        Comentario miCt = new Comentario(0, "Mensaje Prueba", "Respuesta Prueba", LocalDate.of(2018, 10, 30), 5);
        comentarioServicio.registrarComentario(miCt);

        comentarioServicio.eliminarComentario(0);
        Assertions.assertTrue(true);
    }

    @Test
    public void listaComentariosTest() throws Exception {
        Comentario miCt = new Comentario(0, "Mensaje Prueba", "Respuesta Prueba", LocalDate.of(2018, 10, 30), 5);
        comentarioServicio.registrarComentario(miCt);

        List<Comentario> listaComentarios = comentarioServicio.listaComentarios();
        listaComentarios.forEach(System.out::println);
    }
}
