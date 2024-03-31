package op.banco.service.impl;

import org.springframework.stereotype.Service;
import op.banco.entity.Operacion;


@Service
public class CustomerService {
	
	private final CustomerEventsService customerEventsService;

	public CustomerService(CustomerEventsService customerEventsService) {
		super();
		this.customerEventsService = customerEventsService;
	}
	
	public Operacion save(Operacion operacion) {
		System.out.println("Received " + operacion);
		this.customerEventsService.publish(operacion);
		return operacion;		
	}

}
