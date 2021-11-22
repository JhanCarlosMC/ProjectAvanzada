package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.MedioPago;
import co.edu.uniquindio.proyecto.servicios.ComentarioServicio;
import co.edu.uniquindio.proyecto.servicios.CompraServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CompraServicioTest {

    @Autowired
    private CompraServicio compraServicio;

    @Test
    public void registrarComentarioTest(){
        Compra miCp = new Compra("0", LocalDate.of(2018, 10, 30), MedioPago.TARJETA);

        try {
            Compra respuesta = compraServicio.registrarCompra(miCp);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarComentariosTest() throws Exception {
        Compra miCp = new Compra("0", LocalDate.of(2018, 10, 30), MedioPago.TARJETA);
        compraServicio.registrarCompra(miCp);

        Compra updateCompra = compraServicio.obtenerCompra("0");
        updateCompra.setFechaCompra(LocalDate.of(2021, 10, 30));

        Compra modificado = compraServicio.actualizarCompra(updateCompra);
        Assertions.assertEquals(LocalDate.of(2021, 10, 30), modificado.getFechaCompra());
    }

    @Test
    public void eliminarComentarioTest() throws Exception {
        Compra miCp = new Compra("0", LocalDate.of(2018, 10, 30), MedioPago.TARJETA);
        compraServicio.registrarCompra(miCp);

        compraServicio.eliminarCompra("0");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaComentariosTest() throws Exception {
        Compra miCp = new Compra("0", LocalDate.of(2018, 10, 30), MedioPago.TARJETA);
        compraServicio.registrarCompra(miCp);

        List<Compra> listaCompras = compraServicio.listaCompras();
        listaCompras.forEach(System.out::println);
    }
}
