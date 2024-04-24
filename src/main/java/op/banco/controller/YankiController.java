package op.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import op.banco.entity.Operacion;
import op.banco.service.YankiService;
import op.banco.service.impl.CustomerService;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/yanki")
public class YankiController {
	
	@Autowired
	private YankiService yankiService;
	
	private final CustomerService customerService;
	
	public YankiController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/saldo/{numeroCelular}")
	public Mono<Double> consultaSaldo(@PathVariable String numeroCelular) {
        return yankiService.consultaSaldo(numeroCelular)
                .map(cuenta -> cuenta.getSaldo()); // Devuelve solo el campo 'saldo'
    }
	
	@PostMapping(value = "/publishOp")
	public Operacion saveOperacion(@RequestBody Operacion operacion) {
		return this.customerService.save(operacion);
	}
	

}
