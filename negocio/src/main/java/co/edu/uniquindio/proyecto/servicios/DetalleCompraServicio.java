package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;

import java.util.List;

public interface DetalleCompraServicio {

    DetalleCompra regitrarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    DetalleCompra actualizarDetalleCompra(DetalleCompra detalleCompra) throws Exception;

    void eliminarDetalleCompra(String codigo) throws Exception;

    List<DetalleCompra> listaDetallesCompra();

    DetalleCompra obtenerDetalleCompra(String id);
}
