package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadServicioImpl implements CiudadServicio{

    private final CiudadRepo ciudadRepo;

    public CiudadServicioImpl(CiudadRepo ciudadRepo) {
        this.ciudadRepo = ciudadRepo;
    }

    @Override
    public Ciudad registrarCiudad(Ciudad ciudad) throws Exception {
        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        Optional<Ciudad> buscado = ciudadRepo.findById(ciudad.getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("La ciudad no existe");
        }

        return ciudadRepo.save(ciudad);
    }

    @Override
    public void eliminarCiudad(int codigo) throws Exception {
        Optional<Ciudad> buscado = ciudadRepo.findById(codigo);

        if (buscado.isEmpty()) {
            throw new Exception("La ciudad no existe");
        }

        ciudadRepo.deleteById(codigo);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCiudad(Integer id) throws Exception{
        return ciudadRepo.findById(id).orElseThrow(() -> new Exception("El id no corresponde a ninguna ciudad"));
    }
}
