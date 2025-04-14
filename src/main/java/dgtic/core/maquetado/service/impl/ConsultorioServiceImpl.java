package dgtic.core.maquetado.service.impl;

import dgtic.core.maquetado.model.Consultorio;
import dgtic.core.maquetado.repository.ConsultorioRepository;
import dgtic.core.maquetado.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultorioServiceImpl extends GenericServiceImpl<Consultorio, Integer> implements ConsultorioService {
    @Autowired
    ConsultorioRepository consultorioRepository;

    @Override
    protected JpaRepository<Consultorio, Integer> getRepository() {
        return consultorioRepository;
    }

    @Override
    @Transactional
    public Consultorio update(Integer id, Consultorio entity) {
        return consultorioRepository.findById(id).map(entityExistente -> {
            entityExistente.setNombre(entity.getNombre());
            entityExistente.setDireccion(entity.getDireccion());
            entityExistente.setTelefono(entity.getTelefono());
            entityExistente.setHorarios(entity.getHorarios());
            entityExistente.setDisponibles(entity.getDisponibles());
            return consultorioRepository.save(entityExistente);
        }).orElseThrow(() -> new RuntimeException("Consultorio no encontrado con id: " + id));
    }
}
