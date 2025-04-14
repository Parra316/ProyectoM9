package dgtic.core.maquetado.controller;

import dgtic.core.maquetado.model.Pago;
import dgtic.core.maquetado.service.GenericService;
import dgtic.core.maquetado.service.PagoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pago")
public class PagoController extends GenericController<Pago, Integer>{
    private final PagoService pagoService;

    public PagoController(PagoService pagoService){
        this.pagoService = pagoService;
    }

    @Override
    protected GenericService<Pago, Integer> getService() {
        return pagoService;
    }
}
