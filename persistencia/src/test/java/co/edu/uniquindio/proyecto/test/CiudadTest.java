package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {
    @Autowired
    private CiudadRepo ciudadRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    //Registrar una ciudad
    public void registrarCiudadTest() {
        Ciudad miC = new Ciudad(0, "Armenia");
        Ciudad miCGuardado = ciudadRepo.save(miC);
        Assertions.assertNotNull(miCGuardado);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Eliminar una ciudad
    public void eliminarCiudadTest() {
        ciudadRepo.deleteById(1);
        Ciudad miC = ciudadRepo.findById(1).orElse(null);

        Assertions.assertNull(miC);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Actualizar una ciudad
    public void actualizarCiudadTest() {
        Ciudad miC = ciudadRepo.findById(1).orElse(null);
        miC.setNombre("Pereira");
        Ciudad miCNuevo = ciudadRepo.save(miC);
        Assertions.assertEquals("Pereira", miCNuevo.getNombre());
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Mostrar lista de ciudades
    public void listarCiudadesTest() {
        List<Ciudad> listaCiudades = ciudadRepo.findAll();

        Assertions.assertEquals(3, listaCiudades.size());
    }
}
