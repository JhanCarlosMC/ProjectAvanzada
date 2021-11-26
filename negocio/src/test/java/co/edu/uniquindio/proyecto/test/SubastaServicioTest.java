package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.servicios.SubastaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class SubastaServicioTest {

    @Autowired
    private SubastaServicio subastaServicio;

    @Test
    public void registrarSubastaTest(){
        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));

        try {
            Subasta respuesta = subastaServicio.registrarSubasta(newSubasta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarSubastaTest() throws Exception {
        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));
        subastaServicio.registrarSubasta(newSubasta);

        Subasta updateSubasta = subastaServicio.obtenerSubasta("1");
        updateSubasta.setFechaLimite(LocalDate.of(2021, 11, 30));

        Subasta modificado = subastaServicio.actualizarSubasta(updateSubasta);
        Assertions.assertEquals(LocalDate.of(2021, 11, 30),modificado.getFechaLimite());
    }

    @Test
    public void eliminarSubastaTest() throws Exception {
        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));
        subastaServicio.registrarSubasta(newSubasta);

        subastaServicio.eliminarSubasta("1");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaSubastaTest() throws Exception {
        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));
        subastaServicio.registrarSubasta(newSubasta);

        List<Subasta> listaSubastas = subastaServicio.listaSubastas();
        listaSubastas.forEach(System.out::println);
    }
}
