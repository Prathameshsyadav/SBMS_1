package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.excpetion.ProductNotFoundException;

@Controller
public class YourController {
	
	@GetMapping("/welcome")
	public String welcome(Model m) {
		String s = null;
		System.out.println(s.length());
		m.addAttribute("msg", "Welcome home Pratzzz...");
		return "index";
	}
	
	@GetMapping("/product")
	public String getProduct(@RequestParam("pid") Integer pid, Model m) {
		if(pid == 1) {
			m.addAttribute("msg", "Product = apple");
		} else {
			throw new ProductNotFoundException("Record not found");
		}
		return "index";
	}

}
