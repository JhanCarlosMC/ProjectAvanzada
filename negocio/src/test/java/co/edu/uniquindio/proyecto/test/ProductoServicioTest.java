package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ProductoServicioTest {

    @Autowired
    private ProductoServicio productoServicio;

    Usuario miU = null;

    @Test
    public void ingresarProductoTest(){
        Producto newProducto = new Producto("Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
        try {
            Producto respuesta = productoServicio.publicarProducto(newProducto, miU);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarProductoTest() throws Exception {
        Producto newProducto = new Producto("Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
        productoServicio.publicarProducto(newProducto, miU);

        Producto updateProducto = productoServicio.obtenerProducto(1);
        updateProducto.setDescuento(13);

        Producto modificado = productoServicio.actualizarProducto(updateProducto);
        Assertions.assertEquals(13, modificado.getDescuento());
    }

    @Test
    public void eliminarProductoTest() throws Exception {
        Producto newProducto = new Producto("Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
        productoServicio.publicarProducto(newProducto, miU);

        productoServicio.eliminarProducto(1);
        Assertions.assertTrue(true);
    }

    @Test
    public void listaProductosTest() throws Exception {
//        Producto newProducto = new Producto("4", "Play Station 6", 5, "Es la mas nueva", 10000, 0, LocalDate.of(2021, 10, 20));
//        productoServicio.publicarProducto(newProducto);

        List<Producto> listaProductos = productoServicio.listarTodosProductos();
        listaProductos.forEach(System.out::println);
    }

}
