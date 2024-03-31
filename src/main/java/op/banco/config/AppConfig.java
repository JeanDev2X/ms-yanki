package op.banco.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
	
	@Bean
	@Qualifier("productoBancoYanki")
	public WebClient registrarWebClient() {
		return WebClient.create("http://localhost:8021/api/ProductBank");
	}
	
}
