package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest
{

    @Autowired
    private UsuarioRepo usuarioRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    //@Sql("classpath:dataSet.sql")
    public void registrarUsuarioTest()
    {

    }

    @Test
    //@Sql("classpath:dataSet.sql")
    public void eliminarUsuarioTest()
    {

    }

    @Test
    //@Sql("classpath:dataSet.sql")
    public void actualizarUsuarioTest()
    {

    }

    @Test
    //@Sql("classpath:dataSet.sql")
    public void listarUsuariosTest()
    {

    }
}
