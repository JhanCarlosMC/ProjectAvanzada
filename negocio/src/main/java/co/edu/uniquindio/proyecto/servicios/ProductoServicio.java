package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProdCarrito;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto(Producto p) throws Exception;

    Producto actualizarProducto(Producto p) throws Exception;

    void eliminarProducto(String codigo) throws Exception;

    Producto obtenerProductoCodigo(Integer codigo) throws ProductoNoEncontradoException;

    List<Producto> obtenerProductoNombre(String nombre) throws ProductoNoEncontradoException;

    List<Producto>listarProductosCategoria(Categoria categoria);

    List<Producto>listarProductos();

    void comprarProductos(Compra compra) throws Exception;

    List<Producto>buscarProductos(String nombreProducto, String[] filtros);

    List<Producto>listarProductos(String codigoUsuario) throws Exception;

    String recuperarPassword(String email);

    void comentarProducto(Comentario comentario) throws Exception;

    void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception;

    void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception;

}
