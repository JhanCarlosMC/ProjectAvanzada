package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.MedioPago;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
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
public class CompraTest {
    @Autowired
    private CompraRepo compraRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrarCompraTest() {
        Compra miCp = new Compra("0", LocalDate.of(2018, 10, 30), MedioPago.TARJETA);
        Compra miCpGuardado = compraRepo.save(miCp);
        Assertions.assertNotNull(miCpGuardado);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Eliminar una compra
    public void eliminarCompraTest() {
        compraRepo.deleteById("1");
        Compra miCp = compraRepo.findById("1").orElse(null);

        Assertions.assertNull(miCp);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Actualizar una compra
    public void actualizarCompraTest() {
        Compra miCp = compraRepo.findById("1").orElse(null);
        assert miCp != null;
        miCp.setMedioPago(MedioPago.CONTADO);
        Compra miCNuevo = compraRepo.save(miCp);

        Assertions.assertEquals(MedioPago.CONTADO, miCNuevo.getMedioPago());
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Mostrar lista de compras de un usuario
    public void listarComprasTest() {
        List<Compra> listaCompras = compraRepo.findAll();

        Assertions.assertEquals(3, listaCompras.size());
    }
}
