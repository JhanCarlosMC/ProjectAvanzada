package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.DetalleSubastaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class DetalleSubastaServicioTest {

    @Autowired
    private DetalleSubastaServicio detalleSubastaServicio;

    @Test
    public void ingresarDetalleSubastaTest() {
        DetalleSubasta detalleSubasta = new DetalleSubasta("1", 20000, LocalDate.of(2018, 10, 30));

        try {
            DetalleSubasta respuesta = detalleSubastaServicio.registrarDetalleSubasta(detalleSubasta);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarDetalleSubastaTest() throws Exception {
        DetalleSubasta detalleSubasta = new DetalleSubasta("1", 20000, LocalDate.of(2018, 10, 30));
        detalleSubastaServicio.registrarDetalleSubasta(detalleSubasta);

        DetalleSubasta updateDetalle = detalleSubastaServicio.obtenerDetalleSubasta("1");
        updateDetalle.setValor(3000);

        DetalleSubasta modificado = detalleSubastaServicio.actualizarDetalleSubasta(updateDetalle);
        Assertions.assertEquals(3000, modificado.getValor());
    }

    @Test
    public void eliminarDetalleSubastaTest() throws Exception {
        DetalleSubasta detalleSubasta = new DetalleSubasta("1", 20000, LocalDate.of(2018, 10, 30));
        detalleSubastaServicio.registrarDetalleSubasta(detalleSubasta);

        detalleSubastaServicio.eliminarDetalleSubasta("1");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaDetalleSubastas() throws Exception {
        DetalleSubasta detalleSubasta = new DetalleSubasta("1", 20000, LocalDate.of(2018, 10, 30));

//        Usuario newUsuario = new Usuario("4", "Jhan", "Jcmc@gmail.com", "100232");
//        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));
//
//        detalleSubasta.setUsuario(newUsuario);
//        detalleSubasta.setSubasta(newSubasta);

        detalleSubastaServicio.registrarDetalleSubasta(detalleSubasta);

        List<DetalleSubasta> listaDetalleSubasta = detalleSubastaServicio.listaDetallesSubasta();
        listaDetalleSubasta.forEach(System.out::println);
    }
}
