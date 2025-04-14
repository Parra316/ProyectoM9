package dgtic.core.maquetado.service.impl;

import dgtic.core.maquetado.model.Servicio;
import dgtic.core.maquetado.repository.ServicioRepository;
import dgtic.core.maquetado.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioServiceImpl extends GenericServiceImpl<Servicio, Integer> implements ServicioService {

    @Autowired
    ServicioRepository servicioRepository;

    @Override
    JpaRepository<Servicio, Integer> getRepository() {
        return servicioRepository;
    }

    @Override
    @Transactional
    public Servicio update(Integer id, Servicio entity) {
        return servicioRepository.findById(id).map(entityExistente -> {
            entityExistente.setNombre(entity.getNombre());
            entityExistente.setDescripcion(entity.getDescripcion());
            entityExistente.setDuracion(entity.getDuracion());
            entityExistente.setPrecio(entity.getPrecio());
            entityExistente.setEstatus(entity.getEstatus());
            return servicioRepository.save(entityExistente);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }
}
