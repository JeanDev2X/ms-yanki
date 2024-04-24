package op.banco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import op.banco.entity.Operacion;

@AutoConfigureWebTestClient
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootWebfluMsYankiApplicationTests {
	
	@Autowired
	private WebTestClient client;

	@Test
	void contextLoads() {
	}

	@Test
    public void testConsultaSaldo() {
		String numeroCelular = "963791420";
        double saldoEsperado = 50150.0;
        
        // Realizar la solicitud al endpoint
        client.get().uri("/yanki/saldo/{numeroCelular}", numeroCelular)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Double.class)
                .value(saldo -> assertEquals(saldoEsperado, saldo));
        
	}
	
	@Test
    public void testSaveOperacion() {
		Operacion operacion = new Operacion();
        operacion.setDni("47305712");
        // Realizar la solicitud POST al endpoint /publishOp y verificar la respuesta
        client.post().uri("/yanki/publishOp")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(operacion)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Operacion.class)
                .value(op -> assertEquals("47305712", op.getDni())); // Verificar que la Operacion devuelta tenga el ID esperado
        
	}
	
}
