package op.banco.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import op.banco.entity.Operacion;
import op.banco.events.Event;
import op.banco.events.EventType;
import op.banco.events.OperacionCreatedEvent;

import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.customer.name:customers}")
	private String topicCustomer;
		
	@Value("${topic.operacion.name:operacion}")
	private String topicOperaciones;
	
	public void publish(Operacion operacion) {
		OperacionCreatedEvent created = new OperacionCreatedEvent();
		created.setData(operacion);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());
		this.producer.send(topicOperaciones, created);
	}
	
}
