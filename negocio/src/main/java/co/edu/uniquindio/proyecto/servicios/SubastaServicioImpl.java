package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Subasta;
import co.edu.uniquindio.proyecto.repositorios.SubastaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubastaServicioImpl implements SubastaServicio {

    private final SubastaRepo subastaRepo;

    public SubastaServicioImpl(SubastaRepo subastaRepo) {
        this.subastaRepo = subastaRepo;
    }

    @Override
    public Subasta registrarSubasta(Subasta subasta) throws Exception {
        Optional<Subasta> buscado = subastaRepo.findById(subasta.getCodigo());

        if (buscado.isPresent()) {
            throw new Exception("El codigo de la subasta ya existe");
        }
        return subastaRepo.save(subasta);
    }

    @Override
    public Subasta actualizarSubasta(Subasta subasta) throws Exception {
        Optional<Subasta> buscado = subastaRepo.findById(subasta.getCodigo());

        if (buscado.isEmpty()){
            throw new Exception("La subasta no existe");
        }
        return subastaRepo.save(subasta);
    }

    @Override
    public void eliminarSubasta(String id) throws Exception {
        Optional<Subasta> buscado = subastaRepo.findById(id);

        if (buscado.isEmpty()){
            throw new Exception("La subasta no existe");
        }
        subastaRepo.deleteById(id);
    }

    @Override
    public List<Subasta> listaSubastas() {
        return subastaRepo.findAll();
    }

    @Override
    public Subasta obtenerSubasta(String id) {
        return subastaRepo.getById(id);
    }
}
