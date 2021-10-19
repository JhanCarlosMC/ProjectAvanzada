package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DetallerCompraTest {
    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrardetalleCompraTest(){

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void eliminardetalleCompraTest(){


    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizardetalleCompraTest(){

    }

    @Test
    @Sql("classpath:dataSet.sql")
    public void listardetalleCompraTest(){

    }
}
