package dgtic.core.maquetado.controller;

import dgtic.core.maquetado.model.Servicio;
import dgtic.core.maquetado.service.GenericService;
import dgtic.core.maquetado.service.ServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicios")
public class ServiciosController extends GenericController<Servicio, Integer>{
    private final ServicioService servicioService;

    public ServiciosController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @Override
    protected GenericService<Servicio, Integer> getService() {
        return servicioService;
    }
}
