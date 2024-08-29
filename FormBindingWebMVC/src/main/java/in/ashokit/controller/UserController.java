package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.services.UserServices;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@GetMapping("/")
	public String login(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		return "index";
	}
	
	@PostMapping("/login")
	public String saveUser(@Valid User user,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("msg", "Validation Failed");
			return "index";
		}else {

			Boolean saveUser = userService.saveUser(user);
			if(saveUser) {
				model.addAttribute("msg", "User Saved");			
			}else {
				model.addAttribute("msg", "User not saved");
			}
			
			model.addAttribute("user", new User());
			return "index";
		}
		
	}   
	
	
	

}
