package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
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
public class ComentarioTest {
    @Autowired
    private ComentarioRepo comentarioRepo;

    //----------------------------------Metodos CRUD Test----------------------------------------
    @Test
    public void registrarComentarioTest() {
        Comentario miCt = new Comentario("0", "Mensaje Prueba", "Respuesta Prueba", LocalDate.of(2018, 10, 30), 5);
        Comentario miCtGuardado = comentarioRepo.save(miCt);
        Assertions.assertNotNull(miCtGuardado);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Eliminar un comentario
    public void eliminarComentarioTest() {
        comentarioRepo.deleteById("1");
        Comentario miCt = comentarioRepo.findById("1").orElse(null);

        Assertions.assertNull(miCt);
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Actualizar Comentario
    public void actualizarComentarioTest() {
        Comentario miCt = comentarioRepo.findById("1").orElse(null);
        miCt.setCalificacion(1);
        Comentario miCNuevo = comentarioRepo.save(miCt);
        Assertions.assertEquals(1, miCNuevo.getCalificacion());
    }

    @Test
    @Sql("classpath:dataSet.sql")
    //Mostrar lista de comentarios de un usuario
    public void listarComentariosTest() {
        List<Comentario> listaComentario = comentarioRepo.findAll();

        Assertions.assertEquals(3, listaComentario.size());
    }
}
