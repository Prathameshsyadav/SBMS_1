package in.ashokit.exceptionhandling;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.ashokit.excpetion.ProductNotFoundException;

@ControllerAdvice
public class HandlingException {
	
	Logger logger = LoggerFactory.getLogger(HandlingException.class);
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleEx(NullPointerException e,Model m) {
		m.addAttribute("msg","Opps!!!! Null Pointer Exception... Something went wrong");
		logger.error(e.getMessage());
		return "error";
	}
	
	
	@ExceptionHandler(value = ArithmeticException.class)
	public String arithmaticExceptionHandler(ArithmeticException e, Model m) {
		m.addAttribute("msg","Opps!!!! Arithmatic exception... Something went wrong");
		logger.error(e.getMessage());
		return "error";
	}
	
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public String productNotFoundHandler(ProductNotFoundException e, Model m) {
		m.addAttribute("msg", "Opps!!!! Product not found Sorry ");
		logger.error(e.getMessage());
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handEx(Exception e, Model m) {
		m.addAttribute("msg","Opps!!!!  exception... Something went wrong");
		logger.error(e.getMessage());
		return "error";
	}

}
