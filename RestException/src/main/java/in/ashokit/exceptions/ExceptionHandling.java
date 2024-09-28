package in.ashokit.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(value = TicketNotFoundException.class)
	public ResponseEntity<ExInfo> handleTicketNotFoundException(TicketNotFoundException ex) {
		
		ExInfo ex2 = new ExInfo();
		ex2.setExcode("1x0001");
		ex2.setMessage(ex.getMessage());
		ex2.setDate(LocalDate.now());
		
		return new ResponseEntity<ExInfo>(ex2, HttpStatus.BAD_REQUEST);
		
	}

}
