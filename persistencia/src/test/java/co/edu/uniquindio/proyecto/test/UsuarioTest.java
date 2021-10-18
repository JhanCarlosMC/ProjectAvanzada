package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrarUsuarioTest(){

    }

    @Test
    public void eliminarUsuarioTest(){

    }

    @Test
    public void actualizarUsuarioTest(){

    }

    @Test
    public void listarUsuariosTest(){

    }
}
