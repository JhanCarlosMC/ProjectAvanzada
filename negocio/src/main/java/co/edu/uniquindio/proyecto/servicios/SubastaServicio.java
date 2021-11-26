package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Subasta;

import java.util.List;

public interface SubastaServicio {

    Subasta registrarSubasta(Subasta subasta) throws Exception;

    Subasta actualizarSubasta(Subasta subasta) throws Exception;

    void eliminarSubasta(String id) throws Exception;

    List<Subasta> listaSubastas();

    Subasta obtenerSubasta(String id);
}
