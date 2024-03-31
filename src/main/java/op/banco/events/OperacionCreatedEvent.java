package op.banco.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import op.banco.entity.Operacion;

@Data
@EqualsAndHashCode(callSuper = true)
public class OperacionCreatedEvent extends Event<Operacion> {

}
