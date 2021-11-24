package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.repositorios.CompraRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServicioImpl implements CompraServicio{

    private final CompraRepo compraRepo;

    public CompraServicioImpl(CompraRepo compraRepo) {
        this.compraRepo = compraRepo;
    }

    @Override
    public Compra registrarCompra(Compra compra) throws Exception {
        return compraRepo.save(compra);
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
    public void eliminarCompra(String codigo) throws Exception {
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
    public Compra obtenerCompra(String id) {
        return compraRepo.getById(id);
    }
}
