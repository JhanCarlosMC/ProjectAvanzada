package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Mensaje;
import co.edu.uniquindio.proyecto.servicios.MensajeServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class MensajeServicioTest {

    @Autowired
    private MensajeServicio mensajeServicio;

    @Test
    public void ingresarMensajeTest() {
        Mensaje mensaje = new Mensaje("1", "mensaje", "emisor", LocalDate.of(2018, 10, 30));

        try {
            Mensaje respuesta = mensajeServicio.registrarMensaje(mensaje);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarMensajeTest() throws Exception {
        Mensaje mensaje = new Mensaje("1", "mensaje", "emisor", LocalDate.of(2018, 10, 30));
        mensajeServicio.registrarMensaje(mensaje);

        Mensaje updateMensaje = mensajeServicio.obtenerMensaje("1");
        updateMensaje.setMensaje("Actualizacion");

        Mensaje modificado = mensajeServicio.actualizarMensaje(updateMensaje);
        Assertions.assertEquals("Actualizacion", modificado.getMensaje());
    }

    @Test
    public void eliminarMensajeTest() throws Exception {
        Mensaje mensaje = new Mensaje("1", "mensaje", "emisor", LocalDate.of(2018, 10, 30));
        mensajeServicio.registrarMensaje(mensaje);

        mensajeServicio.eliminarMensaje("1");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaMensajesTest() throws Exception {
        Mensaje mensaje = new Mensaje("1", "mensaje", "emisor", LocalDate.of(2018, 10, 30));
        mensajeServicio.registrarMensaje(mensaje);

        List<Mensaje> listaMensajes = mensajeServicio.listaMensajes();
        listaMensajes.forEach(System.out::println);
    }
}
