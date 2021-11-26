package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.excepciones.ProductoNoEncontradoException;

import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto(Producto p) throws Exception;

    Producto actualizarProducto(Producto p) throws Exception;

    void eliminarProducto(String codigo) throws Exception;

    Producto obtenerProductoCodigo(String codigo) throws ProductoNoEncontradoException;

    Producto obtenerProductoNombre(String nombre) throws ProductoNoEncontradoException;

    List<Producto>listarProductos(Categoria categoria);

    List<Producto>listarProductos();

    void comentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception;

    void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception;

    void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception;

    void comprarProductos(Compra compra) throws Exception;

    List<Producto>buscarProductos(String nombreProducto, String[] filtros);

    List<Producto>listarProductos(String codigoUsuario) throws Exception;

    String recuperarPassword(String email);
}
