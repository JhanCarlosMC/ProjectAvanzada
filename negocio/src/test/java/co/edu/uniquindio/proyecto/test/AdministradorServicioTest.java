package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Administrador;
import co.edu.uniquindio.proyecto.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void ingresarAdministradorTest() {
        Administrador administrador = Administrador.builder()
                .codigo("123").nombre("juan").email("juan@mail.com")
                .password("123").build();

        try {
            Administrador respuesta = administradorServicio.registrarAdministrador(administrador);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarAdministradorTest() throws Exception {
        Administrador administrador = Administrador.builder().codigo("123").nombre("juan").email("juan@mail.com")
                .password("123").build();
        administradorServicio.registrarAdministrador(administrador);

        Administrador updateAdmin = administradorServicio.obtenerAdministrador("123");
        updateAdmin.setPassword("321");

        Administrador modificado = administradorServicio.actualizarAdministrador(updateAdmin);
        Assertions.assertEquals("321", modificado.getPassword());
    }

    @Test
    public void eliminarAdministradorTest() throws Exception {
        Administrador administrador = Administrador.builder().codigo("123").nombre("juan").email("juan@mail.com")
                .password("123").build();
        administradorServicio.registrarAdministrador(administrador);

        administradorServicio.eliminarAdministrador("123");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaAdministradoresTest() throws Exception {
        Administrador administrador = Administrador.builder().codigo("123").nombre("juan").email("juan@mail.com")
                .password("123").build();
        administradorServicio.registrarAdministrador(administrador);

        List<Administrador> listaAdministradores = administradorServicio.listaAdministradores();
        listaAdministradores.forEach(System.out::println);
    }
}
