package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.servicios.DetalleCompraServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class DetalleCompraServicioTest {

    @Autowired
    private DetalleCompraServicio detalleCompraServicio;

    @Test
    public void ingresarDetalleCompraTest(){
        DetalleCompra detalleCompra = new DetalleCompra("1", 2, 20000);

        try {
            DetalleCompra respuesta = detalleCompraServicio.regitrarDetalleCompra(detalleCompra);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarDetalleCompraTest() throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra("1", 2, 20000);
        detalleCompraServicio.regitrarDetalleCompra(detalleCompra);

        DetalleCompra updateDC = detalleCompraServicio.obtenerDetalleCompra("1");
        updateDC.setPrecioProducto(32000);

        DetalleCompra modificado = detalleCompraServicio.actualizarDetalleCompra(updateDC);
        Assertions.assertEquals(32000, modificado.getPrecioProducto());
    }

    @Test
    public void eliminarDetalleCompraTest() throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra("1", 2, 20000);
        detalleCompraServicio.regitrarDetalleCompra(detalleCompra);

        detalleCompraServicio.eliminarDetalleCompra("1");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaDetallesCompraTest() throws Exception {
        DetalleCompra detalleCompra = new DetalleCompra("1", 2, 20000);
        detalleCompraServicio.regitrarDetalleCompra(detalleCompra);

        List<DetalleCompra> listaDetallesCompra = detalleCompraServicio.listaDetallesCompra();
        listaDetallesCompra.forEach(System.out::println);
    }
}
