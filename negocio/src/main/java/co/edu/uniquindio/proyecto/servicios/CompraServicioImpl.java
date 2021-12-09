package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import co.edu.uniquindio.proyecto.servicios.email.EmailBody;
import co.edu.uniquindio.proyecto.servicios.email.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements CompraServicio{

    private final CompraRepo compraRepo;
    private EmailBody miEB;
    private EmailService miES;

    public CompraServicioImpl(CompraRepo compraRepo) {
        this.compraRepo = compraRepo;
        this.miEB = new EmailBody();
        this.miES = new EmailService();
    }

    @Override
    public Compra registrarCompra(Compra compra) throws Exception
    {
        Usuario miU = compra.getUsuario();

        String mensajeCompras = obtenerMensajeCompras(compra);

        String mensaje = "<h1>Hola, " + miU.getNombre() + "</h1>"
                + "<br/>"
                + "<p>Tu registro de compra fue exitoso."
                + "<br/>"
                + "<h2>Productos: </h2>"
                + mensajeCompras
                + "<br/>"
                + "<br/>"
                + "Atentamente, "
                + "<h3>Unishop</h3>"
                + "</p>";

        miEB = new EmailBody(miU.getEmail(), mensaje,"[Compra Realizada]");
        miES.sendEmail(miEB);
        return compraRepo.save(compra);
    }

    private String obtenerMensajeCompras(Compra miC)
    {
        String aux = "";
        Producto miP;

        for(int i = 0 ; i < miC.getDetalleCompras().size() ; i++)
        {
            miP = miC.getDetalleCompras().get(i).getProducto();

            aux = "Nombre del producto: "+ miP.getNombre()
                    + "<br/>"
                    + "Precio del producto: "+ miP.getPrecio()
                    + "<br/>"
                    + "Descripcion del producto: "+ miP.getDescripcion()
                    + "<br/>"
                    + "Metodo de pago: "+ miC.getMedioPago();
        }
        return aux;
    }

    @Override
    public Compra actualizarCompra(Compra compra) throws Exception {
        Optional<Compra> buscado = compraRepo.findById(compra.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("La compra no existe");
        }

        return compraRepo.save(compra);
    }

    @Override
    public void eliminarCompra(Integer codigo) throws Exception
    {
        Optional<Compra> buscado = compraRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("La compra no existe");
        }

        compraRepo.deleteById(codigo);
    }

    @Override
    public List<Compra> listaCompras() {
        return compraRepo.findAll();
    }

    @Override
    public Compra obtenerCompra(Integer id) {
        return compraRepo.getById(id);
    }
}
