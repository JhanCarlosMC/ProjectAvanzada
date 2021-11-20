package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;

import java.util.List;

public interface DetalleSubastaServicio {

    DetalleSubasta registrarDetalleSubasta(DetalleSubasta detalleSubasta) throws Exception;

    DetalleSubasta actualizarDetalleSubasta(DetalleSubasta detalleSubasta) throws Exception;

    void eliminarUsuario(String codigo) throws Exception;

    List<DetalleSubasta> listaDetallesSubasta();
}
