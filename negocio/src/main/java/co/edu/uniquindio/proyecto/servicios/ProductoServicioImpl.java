package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.excepciones.ProductoNoEncontradoException;
import co.edu.uniquindio.proyecto.repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.email.EmailBody;
import co.edu.uniquindio.proyecto.servicios.email.EmailService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicioImpl implements ProductoServicio{

    private final ProductoRepo productoRepo;
    private final ComentarioRepo comentarioRepo;
    private final CompraRepo compraRepo;
    private final DetalleCompraRepo detalleCompraRepo;
    private EmailBody miEB;
    private EmailService miES;

    public ProductoServicioImpl(ProductoRepo productoRepo, ComentarioRepo comentarioRepo, CompraRepo compraRepo, DetalleCompraRepo detalleCompraRepo){
        this.productoRepo = productoRepo;
        this.comentarioRepo = comentarioRepo;
        this.compraRepo = compraRepo;
        this.detalleCompraRepo = detalleCompraRepo;
        this.miEB = new EmailBody();
        this.miES = new EmailService();
    }

    @Override
    public Producto publicarProducto(Producto p, Usuario usuarioSesion) throws Exception
    {
        String mensaje = "<h1>Unishop</h1>";

        mensaje += "<h2>Hola, " + usuarioSesion.getNombre() + "</h2>"
                + "<br/>"
                + "<p>Tu producto ha sido agregado correctamente."
                + "<br/>"
                + "<h4>DETALLES DEL PRODUCTO</h4>"
                + "<br/>"
                + "Nombre del producto:" + p.getNombre()
                + "<br/>"
                + "Descripción del producto:"+p.getDescripcion()
                + "<br/>"
                + "Precio: compra: $" + p.getPrecio()
                + "<br/>"
                + "<br/>"
                + "Atentamente, "
                + "<h3>Unishop</h3>"
                + "</p>";

        miEB = new EmailBody(usuarioSesion.getEmail(),mensaje,"[Registro de producto]");
        try
        {
            miES.sendEmail(miEB);
            return productoRepo.save(p);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Producto actualizarProducto(Producto p) throws Exception
    {
        return productoRepo.save(p);
    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception
    {
        Optional<Producto> producto = productoRepo.findById(codigo);

        if(producto.isEmpty())
        {
            throw new Exception("El código no existe");
        }
        else
        {
            productoRepo.deleteById(codigo);//tener en cuenta que cuando se elimine revisar que registros dependen de otros
        }
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws ProductoNoEncontradoException {
        return productoRepo.findById(codigo).orElseThrow(() -> new ProductoNoEncontradoException("El producto no fue encontrado"));
    }

    @Override
    public void eliminarProductoFavorito(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void guardarProductoFavoritos(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comentarProducto(Comentario comentario) throws Exception {
        comentario.setFechaComentario(LocalDate.now());
        comentarioRepo.save(comentario);
    }

    @Override
    public List<Producto> listarProductos(Categoria categoria) {
        return null;
    }

    @Override
    public List<Producto> listarTodosProductos() {
        return productoRepo.findAll();
    }

    @Override
    public List<Producto> listarPorCategoria(Categoria categoria) {
        return productoRepo.listarPorCategoria(categoria);
    }

    @Override
    public List<Producto> buscarProductos(String nombreProducto, String[] filtros) {
        return productoRepo.buscarProductoNombre(nombreProducto);
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario)
    {
        return productoRepo.listarCodUsuario(codigoUsuario);
    }

    @Override
    public List<CategoriaEnum> listarCategorias() {
        return Arrays.asList(CategoriaEnum.values());
    }

    @Override
    public CategoriaEnum obtenerCategoria(String categoria) throws Exception {
        return CategoriaEnum.valueOf(categoria);
    }

    @Override
    public Compra comprarProductos(Usuario usuario, ArrayList<ProductoCarrito> productos, MedioPago medioPago) throws Exception{

        try{
            Compra c = new Compra();
            c.setFechaCompra(LocalDate.now(ZoneId.of("America/Bogota")));
            c.setUsuario(usuario);
            c.setMedioPago(medioPago);

            Compra compraGuardada = compraRepo.save(c);

            DetalleCompra dc;
            for (ProductoCarrito p : productos){
                dc = new DetalleCompra();
                dc.setCompra(compraGuardada);
                dc.setPrecioProducto(p.getPrecio());
                dc.setUnidades(p.getUnidades());
                dc.setProducto(productoRepo.findById(p.getId()).get());
                //TODO verificar que las unidades del producto si estén disponibles
                detalleCompraRepo.save(dc);
            }
            return compraGuardada;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
