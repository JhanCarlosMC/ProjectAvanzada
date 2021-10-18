package co.edu.uniquindio.proyecto.test;




import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class productoTest {

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    public void registrarProductoTest(){
        Producto producto = new Producto("1234","celular",
                4,"celulares doble sim",1000000 ,5,2021/12/04,  );




    }
}
