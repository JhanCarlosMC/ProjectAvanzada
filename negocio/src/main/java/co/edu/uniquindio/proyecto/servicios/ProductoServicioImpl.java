package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProdCarrito;
import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.excepciones.ProductoNoEncontradoException;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    private final ProductoRepo productoRepo;

    public ProductoServicioImpl(ProductoRepo productoRepo){
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        try {
            return productoRepo.save(p);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto actualizarProducto(Producto p) throws Exception {
        Optional<Producto> buscado = productoRepo.findByCodigo(p.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("EL producto no existe");
        }
        return productoRepo.save(p);
    }

    @Override
    public void eliminarProducto(String codigo) throws Exception {
        Optional<Producto> producto = productoRepo.findById(codigo);

        if(producto.isEmpty()){
            throw new Exception("El código no existe");
        }
        productoRepo.deleteById(codigo);//tener en cuenta que cuando se elimine revisar que registros dependen de otros
        //cascade delete hibernate
    }

    @Override
    public Producto obtenerProductoCodigo(String codigo) throws ProductoNoEncontradoException {
        return productoRepo.findById(codigo).orElseThrow(() -> new ProductoNoEncontradoException("El código del producto no es valido"));
    }

    @Override
    public List<Producto> obtenerProductoNombre(String nombre) throws ProductoNoEncontradoException {
        return productoRepo.buscarProductoNombre(nombre);
    }

    @Override
    public void comprarProductos(Compra compra) throws Exception {

    }

    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public List<Producto> listarProductosCategoria(Categoria categoria) {
        return productoRepo.listaProductosCategoria(categoria);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public List<Producto> buscarProductos(String nombreProducto, String[] filtros) {
        return productoRepo.buscarProductoNombre(nombreProducto);
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario) throws Exception {
        return null;
    }

    @Override
    public String recuperarPassword(String email) {
        return null;
    }

    @Override
    public Compra comprarProductos(Usuario usuario, ArrayList<ProdCarrito> productos, String medioPago) throws Exception {
        return null;
    }
}