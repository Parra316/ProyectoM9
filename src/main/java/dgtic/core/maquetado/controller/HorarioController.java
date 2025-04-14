package dgtic.core.maquetado.controller;

import dgtic.core.maquetado.model.Horario;
import dgtic.core.maquetado.service.GenericService;
import dgtic.core.maquetado.service.HorarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
public class HorarioController extends GenericController<Horario, Integer>{
    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @Override
    protected GenericService<Horario, Integer> getService() {
        return horarioService;
    }
}
