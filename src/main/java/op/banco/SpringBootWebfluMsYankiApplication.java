package op.banco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebfluMsYankiApplication {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluMsYankiApplication.class, args);
	}

}
