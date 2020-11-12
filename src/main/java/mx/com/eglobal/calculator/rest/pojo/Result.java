package mx.com.eglobal.calculator.rest.pojo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"resultado"
})
public class Result {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("resultado")
	private BigDecimal resultado;
	
	public Result() {
		//For Jackson Construct
	}

	public String getId() {
		return id;
	}

	public BigDecimal getResultado() {
		return resultado;
	}
	
	public static class Builder {
		String id;
		BigDecimal resultado;
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder setResultado(BigDecimal resultado) {
			this.resultado = resultado;
			return this;
		}
		
		public Result build() {
			Result result = new Result();
			result.id = this.id;
			result.resultado = this.resultado;
			return result;
		}
		
	}
	
}
