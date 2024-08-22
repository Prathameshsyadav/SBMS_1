package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/home")
	public String home(Model m) {
		m.addAttribute("msg", "Welcome Home Prathamesh");
		return "index";
	}
	
	@GetMapping("/greet")
	public String greetMSG() {
		int i = 10/0;
		
		return "greet";
	}

}
