package op.banco.service;

import op.banco.dto.CuentaBanco;
import reactor.core.publisher.Mono;

public interface YankiService {
	
	Mono<CuentaBanco> consultaSaldo(String numeroCelular);

}
