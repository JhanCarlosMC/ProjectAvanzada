package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.excepciones.ProductoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductoServicio {

    Producto publicarProducto(Producto p, Usuario u) throws Exception;

    Producto publicarProducto(Producto p) throws  Exception;

    Producto actualizarProducto(Producto p) throws Exception;

    void eliminarProducto(Integer codigo) throws Exception;

    Producto obtenerProducto(Integer codigo) throws ProductoNoEncontradoException;

    List<Producto>listarProductos(Categoria categoria);

    List<Producto>listarTodosProductos();

    List<Producto>listarPorCategoria(Categoria categoria);

    void comentarProducto(Comentario comentario) throws Exception;

    void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception;

    void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception;

    List<Producto>buscarProductos(String nombreProducto, String[] filtros);

    List<Producto>listarProductos(String codigoUsuario);

    List<CategoriaEnum>listarCategorias();

    CategoriaEnum obtenerCategoria(String categoria) throws Exception;

    Compra comprarProductos(Usuario usuario, ArrayList<ProductoCarrito>producto, MedioPago medioPago) throws Exception;

    Integer obtenerUnidadesProducto(Integer codigo) throws Exception;

    Integer obtenerPromedioComentario(Integer codigo) throws Exception;
}
