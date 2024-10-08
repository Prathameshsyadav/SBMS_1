package in.ashokit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider {

	@GetMapping("/message")
	public String getMessage() {
		return "Welcome to ashok it";
	}
	
	@GetMapping("/greet")
	public String getGreet() {
		return "Good Morning";
	}
}
