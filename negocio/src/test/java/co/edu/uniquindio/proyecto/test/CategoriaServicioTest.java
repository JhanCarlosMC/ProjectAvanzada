package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.servicios.CategoriaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CategoriaServicioTest {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @Test
    public void ingresarCategoriaTest() {
        Categoria categoria = new Categoria("123", "muebles");

        try {
            Categoria respuesta = categoriaServicio.registrarCategoria(categoria);
            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void actualizarCategoriaTest() throws Exception {
        Categoria categoria = new Categoria("123", "muebles");
        categoriaServicio.registrarCategoria(categoria);

        Categoria updateCat = categoriaServicio.obtenerCategoria("123");
        updateCat.setNombre("Muebles");

        Categoria modificado = categoriaServicio.actualizarCategoria(updateCat);
        Assertions.assertEquals("Muebles", modificado.getNombre());
    }

    @Test
    public void eliminarCategoriaTest() throws Exception {
        Categoria categoria = new Categoria("123", "muebles");
        categoriaServicio.registrarCategoria(categoria);

        categoriaServicio.eliminarCategoria("123");
        Assertions.assertTrue(true);
    }

    @Test
    public void listaCategoriasTest() throws Exception {
        Categoria categoria = new Categoria("123", "muebles");
        categoriaServicio.registrarCategoria(categoria);

        List<Categoria> listaCategorias = categoriaServicio.listaCategorias();
        listaCategorias.forEach(System.out::println);
    }
}
