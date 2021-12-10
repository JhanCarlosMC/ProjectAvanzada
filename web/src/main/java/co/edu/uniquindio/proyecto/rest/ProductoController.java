package co.edu.uniquindio.proyecto.rest;

import co.edu.uniquindio.proyecto.dto.Mensaje;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<Producto> ListarProductos(){
        return  productoServicio.listarTodosProductos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable("id") Integer idProducto) {
        try {

            return  ResponseEntity.status(200).body(productoServicio.obtenerProducto(idProducto));

        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearProducto(@RequestBody Producto producto) {
        try {
            productoServicio.publicarProducto(producto);
            return  ResponseEntity.status(201).body(new Mensaje("El producto se registro correctamente"));

        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<Mensaje> actualizarUsuario(@RequestBody Producto producto) {
        try {
            productoServicio.actualizarProducto(producto);
            return  ResponseEntity.status(200).body(new Mensaje("El producto se actualizo correctamente"));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminarUsuario(@PathVariable("id")Integer id){
        try {
            productoServicio.eliminarProducto(id);
            return  ResponseEntity.status(200).body(new Mensaje("El producto se elimino correctamente"));

        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/favoritos/{id}")
    public ResponseEntity<?> obtenerProductosFavoritos(@PathVariable("id") String id){

        try {
            List<Producto> productos = usuarioServicio.listarProductosFavoritos(id);
            return  ResponseEntity.status(200).body(productos);
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }

    @GetMapping("/extra/{id}")
    public ResponseEntity<?> obtenerUnidadesProducto(@PathVariable("id") Integer id){
        try {

            return  ResponseEntity.status(200).body(productoServicio.obtenerUnidadesProducto(id));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @GetMapping("/extra2/{id}")
    public ResponseEntity<?> obtenerPromedio(@PathVariable("id") Integer id){
        try {

            return  ResponseEntity.status(200).body(productoServicio.obtenerPromedioComentario(id));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
