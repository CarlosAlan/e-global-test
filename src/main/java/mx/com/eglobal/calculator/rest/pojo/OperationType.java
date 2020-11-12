package mx.com.eglobal.calculator.rest.pojo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"numero_1",
"numero_2",
"operacion"
})
public class OperationType {
	
	@JsonProperty("numero_1")
	private BigDecimal numero1;
	
	@JsonProperty("numero_2")
	private BigDecimal numero2;
	
	@JsonProperty("operacion")
	private String operacion;

	public OperationType() {
		// For Json Construct
	}
	
	public BigDecimal getNumero1() {
		return numero1;
	}

	public BigDecimal getNumero2() {
		return numero2;
	}

	public String getOperacion() {
		return operacion;
	}

	public static class Builder {
		BigDecimal numero1;
		BigDecimal numero2;
		String operacion;
		
		public Builder setNumero1(BigDecimal numero1) {
			this.numero1 = numero1;
			return this;
		}
		
		public Builder setNumero2(BigDecimal numero2) {
			this.numero2 = numero2;
			return this;
		}
		
		public Builder setOperacion(String operacion) {
			this.operacion = operacion;
			return this;
		}
		
		public OperationType build() {
			OperationType operation = new OperationType();
			operation.numero1 = this.numero1;
			operation.numero2 = this.numero2;
			operation.operacion = this.operacion;
			return operation;
		}
		
	}
	
}
