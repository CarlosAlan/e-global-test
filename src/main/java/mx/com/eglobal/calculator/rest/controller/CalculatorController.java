package mx.com.eglobal.calculator.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import mx.com.eglobal.calculator.rest.pojo.GeneralResponse;
import mx.com.eglobal.calculator.rest.pojo.OperationType;
import mx.com.eglobal.calculator.rest.pojo.Result;
import mx.com.eglobal.calculator.rest.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculator/")
public class CalculatorController {

	@Autowired
	CalculatorService service;

	@GetMapping("/ping")
	public GeneralResponse ping() throws JsonProcessingException {
	    return new GeneralResponse("OK", "Welcome to API Calculator");
	}
	
	@PostMapping("/operation")
	public Result addMovie(@Validated @RequestBody OperationType request) throws JsonProcessingException {
		return service.executeOperation(request);
	}
}
