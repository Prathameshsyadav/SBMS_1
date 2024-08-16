package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@GetMapping("/greet")
	public ModelAndView greet() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Good Morning, Welcome to web mvc app");
		mav.setViewName("index");
		return mav;
	}

}
