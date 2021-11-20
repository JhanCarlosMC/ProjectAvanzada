package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleCompra;
import co.edu.uniquindio.proyecto.repositorios.DetalleCompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServicioImpl implements DetalleCompraServicio{

    private final DetalleCompraRepo detalleCompraRepo;

    public DetalleCompraServicioImpl(DetalleCompraRepo detalleCompraRepo) {
        this.detalleCompraRepo = detalleCompraRepo;
    }

    @Override
    public DetalleCompra regitrarDetalleCompra(DetalleCompra detalleCompra) throws Exception {
        return detalleCompraRepo.save(detalleCompra);
    }

    @Override
    public DetalleCompra actualizarDetalleCompra(DetalleCompra detalleCompra) throws Exception {
        Optional<DetalleCompra> buscado = detalleCompraRepo.findById(detalleCompra.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("El detalle compra no existe");
        }

        return detalleCompraRepo.save(detalleCompra);
    }

    @Override
    public void eliminarDetalleCompra(String codigo) throws Exception {
        Optional<DetalleCompra> buscado = detalleCompraRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El detalle compra no existe");
        }

        detalleCompraRepo.deleteById(codigo);
    }

    @Override
    public List<DetalleCompra> listaDetallesCompra() {
        return detalleCompraRepo.findAll();
    }
}
