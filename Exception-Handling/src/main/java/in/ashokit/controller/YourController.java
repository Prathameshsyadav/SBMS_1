package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YourController {
	
	@GetMapping("/welcome")
	public String welcome(Model m) {
		String s = null;
		System.out.println(s.length());
		m.addAttribute("msg", "Welcome home Pratzzz...");
		return "index";
	}

}
