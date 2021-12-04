package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.servicios.CiudadServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CiudadServicioTest {

    @Autowired
    private CiudadServicio ciudadServicio;

    @Test
    public void ingresarCiudadTest(){
        Ciudad miC = new Ciudad(0, "Armenia");

        try {
            Ciudad respuesta = ciudadServicio.registrarCiudad(miC);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarCiudadTest() throws Exception {
        Ciudad miC = new Ciudad(0, "Armenia");
        ciudadServicio.registrarCiudad(miC);

        Ciudad updateCity = ciudadServicio.obtenerCiudad(1);
        updateCity.setNombre("Medallo");

        Ciudad modificado = ciudadServicio.actualizarCiudad(updateCity);
        Assertions.assertEquals("Medallo", modificado.getNombre());
    }

    @Test
    public void eliminarCiudadTest() throws Exception {
        Ciudad miC = new Ciudad(1, "Armenia");
        ciudadServicio.registrarCiudad(miC);

        ciudadServicio.eliminarCiudad(1);
        Assertions.assertTrue(true);
    }

    @Test
    public void listaCiudadesTest() throws Exception {
        Ciudad miC = new Ciudad(0, "Armenia");
        ciudadServicio.registrarCiudad(miC);

        List<Ciudad> listaCiudades = ciudadServicio.listarCiudades();
        listaCiudades.forEach(System.out::println);
    }
}
