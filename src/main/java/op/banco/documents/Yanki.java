package op.banco.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Yanki {
	
	private String dni;
	private String numeroCelular;
	private double saldo;
//	private String imei;
//	private String correo;
	
	public Yanki(double saldo) {		
		this.saldo = saldo;
	}	
	
}
