package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.DetalleSubasta;
import co.edu.uniquindio.proyecto.repositorios.DetalleSubastaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleSubastaServicioImpl implements DetalleSubastaServicio{

    private final DetalleSubastaRepo detalleSubastaRepo;

    public DetalleSubastaServicioImpl(DetalleSubastaRepo detalleSubastaRepo) {
        this.detalleSubastaRepo = detalleSubastaRepo;
    }

    @Override
    public DetalleSubasta registrarDetalleSubasta(DetalleSubasta detalleSubasta) throws Exception {
        return detalleSubastaRepo.save(detalleSubasta);
    }

    @Override
    public DetalleSubasta actualizarDetalleSubasta(DetalleSubasta detalleSubasta) throws Exception {
        Optional<DetalleSubasta> buscado = detalleSubastaRepo.findById(detalleSubasta.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("El detalle busbasta no existe");
        }

        return detalleSubastaRepo.save(detalleSubasta);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {
        Optional<DetalleSubasta> buscado = detalleSubastaRepo.findById(codigo);

        if (buscado.isEmpty()){
            throw new Exception("El detalle busbasta no existe");
        }

        detalleSubastaRepo.deleteById(codigo);
    }

    @Override
    public List<DetalleSubasta> listaDetallesSubasta() {
        return detalleSubastaRepo.findAll();
    }
}
