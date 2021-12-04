package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;

import java.util.List;

public interface CompraServicio {

    Compra registrarCompra(Compra compra) throws Exception;

    Compra actualizarCompra(Compra compra) throws Exception;

    void eliminarCompra(Integer codigo) throws Exception;

    List<Compra> listaCompras();

    Compra obtenerCompra(Integer id);
}
