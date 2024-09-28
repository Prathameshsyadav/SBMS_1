package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exceptions.TicketNotFoundException;

@RestController
public class ExController {
	
	@GetMapping("/e/{id}")
	public String getWelcome(@PathVariable Integer id ) {
		if(id == 1) {
			return "Welcome to Ashokit";
		} else {
			throw new TicketNotFoundException("Id is not found");
		}
	}
}
