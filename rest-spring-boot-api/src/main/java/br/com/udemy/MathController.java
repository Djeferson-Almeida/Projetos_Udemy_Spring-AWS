package br.com.udemy;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.converters.NumberConverter;
import br.com.udemy.exceptions.UnsupportedMathOperationException;
import br.com.udemy.math.SimpleMath;

@RestController
public class MathController {

	private static final String template ="Hello, %s!";
	private static AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET) 
	public Double sum(@PathVariable(value = "numberOne")String numberOne,
	 @PathVariable(value = "numberTwo")String numberTwo
	  )throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	 return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/substraction/{numberOne}/{numberTwo}",
			method=RequestMethod.GET) 
	public Double substraction(@PathVariable(value = "numberOne")String numberOne,
	 @PathVariable(value = "numberTwo")String numberTwo
	  )throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	 return math.substraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
			method=RequestMethod.GET) 
	public Double multiplication(@PathVariable(value = "numberOne")String numberOne,
	 @PathVariable(value = "numberTwo")String numberTwo
	  )throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	 return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
			method=RequestMethod.GET) 
	public Double mean(@PathVariable(value = "numberOne")String numberOne,
	 @PathVariable(value = "numberTwo")String numberTwo
	  )throws Exception{
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) { 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
	 return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	}
	

