package dgtic.core.maquetado.controller;

import dgtic.core.maquetado.model.Usuario;
import dgtic.core.maquetado.service.GenericService;
import dgtic.core.maquetado.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController extends GenericController<Usuario, Integer>{
    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    protected GenericService<Usuario, Integer> getService() {
        return usuarioService;
    }
}
