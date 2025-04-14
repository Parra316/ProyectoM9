package dgtic.core.maquetado.service.impl;

import dgtic.core.maquetado.model.Usuario;
import dgtic.core.maquetado.repository.UsuarioRepository;
import dgtic.core.maquetado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    JpaRepository<Usuario, Integer> getRepository() {
        return usuarioRepository;
    }

    public List<Usuario> findAllAdmin() {
        return usuarioRepository.findByRolesNombre("administrador");
    }

    public List<Usuario> findAllClients() {
        return usuarioRepository.findByRolesNombre("cliente");
    }

    @Override
    @Transactional
    public Usuario update(Integer id, Usuario entity) {
        return usuarioRepository.findById(id).map(entityExistente -> {
            entityExistente.setNombre(entity.getNombre());
            entityExistente.setApellido(entity.getApellido());
            entityExistente.setCorreo(entity.getCorreo());
            entityExistente.setContrasena(entity.getContrasena());
            entityExistente.setTelefono(entity.getTelefono());
            entityExistente.setRegistro(entity.getRegistro());
            return usuarioRepository.save(entityExistente);
        }).orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }
}
