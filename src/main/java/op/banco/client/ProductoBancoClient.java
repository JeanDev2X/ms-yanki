package op.banco.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import op.banco.dto.CuentaBanco;
import reactor.core.publisher.Mono;

@Service
public class ProductoBancoClient {

	private static final Logger log = LoggerFactory.getLogger(CuentaBanco.class);

	@Autowired
	@Qualifier("productoBancoYanki")
	private WebClient productoBancoClient;

	public Mono<CuentaBanco> consultaSaldo(String numeroCelular) {

		log.info("nuermo de cueta : " + numeroCelular);

		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("numeroCelular", numeroCelular);		

		return productoBancoClient.get().uri("/saldoyanki/{numeroCelular}", pathVariable)
				.accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(CuentaBanco.class);

	}

}
