package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    public void ingresarProductoTest(){
        Producto newProducto = new Producto("4", "Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));

        try {
            Producto respuesta = productoServicio.publicarProducto(newProducto);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarProductoTest() throws Exception {
        Producto newProducto = new Producto("4", "Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
        productoServicio.publicarProducto(newProducto);

        Producto updateProducto = productoServicio.obtenerProductoCodigo("4");
        updateProducto.setDescuento(13);

        Producto modificado = productoServicio.actualizarProducto(updateProducto);
        Assertions.assertEquals(13, modificado.getDescuento());
    }

    @Test
    public void eliminarProductoTest() throws Exception {
        Producto newProducto = new Producto("4", "Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
        productoServicio.publicarProducto(newProducto);

        productoServicio.eliminarProducto("4");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaProductosTest() throws Exception {
//        Producto newProducto = new Producto("4", "Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
//        productoServicio.publicarProducto(newProducto);

        List<Producto> listaProductos = productoServicio.listarProductos();
        listaProductos.forEach(System.out::println);
    }
}
