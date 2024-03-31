package op.banco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import op.banco.client.ProductoBancoClient;
import op.banco.documents.Yanki;
import op.banco.dto.CuentaBanco;
import op.banco.service.YankiService;
import reactor.core.publisher.Mono;

@Service
public class YankiServiceImpl implements YankiService{
	
	@Autowired
	private ProductoBancoClient productoBancoClient;

	@Override
	public Mono<CuentaBanco> consultaSaldo(String numeroCelular) {
		System.out.println("SALDO-YANKI");
		Mono<CuentaBanco> oper1 = productoBancoClient.consultaSaldo(numeroCelular);		
		return oper1;
	}

}
