package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.DetalleSubastaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetalleSubastaTest {

    @Autowired
    private DetalleSubastaRepo detalleSubastaRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrardetalleSubastaTest(){

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void eliminardetalleSubastaTest(){

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizardetalleSubastaTest(){

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void listardetalleSubastaTest(){

    }
}
