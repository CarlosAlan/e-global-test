package mx.com.eglobal.calculator.rest.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.eglobal.calculator.rest.dto.BinnacleEntity;
import mx.com.eglobal.calculator.rest.pojo.OperationType;
import mx.com.eglobal.calculator.rest.pojo.Result;
import mx.com.eglobal.calculator.rest.repository.BinnacleRepository;
import mx.com.eglobal.calculator.rest.util.Aes;

@Service
public class CalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
	
	private static final String SECRET_KEY = "e-globalKey";
	
	@Autowired
	private BinnacleRepository repository;
	
	public Result executeOperation(OperationType operation) throws JsonProcessingException {
		
		logger.info("CalculatorService.executeOperation()");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String contentOperation = objectMapper.writeValueAsString(operation);
		
		BigDecimal result;
		
		switch(operation.getOperacion().toUpperCase()) {
			case "SUMA":
				result = operation.getNumero1().add(operation.getNumero2());
			break;
			case "RESTA":
				result = operation.getNumero1().subtract(operation.getNumero2());
			break;
			case "MULTIPLICACION":
				result = operation.getNumero1().multiply(operation.getNumero2());
			break;
			case "DIVISION":
				result = operation.getNumero1().divide(operation.getNumero2());
			break;
			default:
				throw new IllegalArgumentException("Operacion no permitida");
		}
		
		BinnacleEntity entity = new BinnacleEntity();
		entity.setContent(contentOperation);
		entity.setResult(Aes.encrypt(String.valueOf(result), SECRET_KEY));
		
		Long id = repository.saveAndFlush(entity).getId();
		
		return new Result.Builder()
				.setId(String.valueOf(id))
				.setResultado(result)
				.build();
	}
	
}
