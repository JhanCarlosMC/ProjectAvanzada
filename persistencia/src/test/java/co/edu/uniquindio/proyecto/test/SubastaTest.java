package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SubastaTest {

    @Autowired
    private SubastaRepo subastaRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrarSubastaTest() {
        Subasta newSubasta = new Subasta("1", LocalDate.of(2018, 10, 30));
        Subasta saveSubasta = subastaRepo.save(newSubasta);

        Assertions.assertNotNull(saveSubasta);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void eliminarSubastaTest() {

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarSubastaTest() {

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void listarSubastaTest() {
        List<Subasta> listaSubastas = subastaRepo.findAll();
        System.out.println(listaSubastas);
    }
}
