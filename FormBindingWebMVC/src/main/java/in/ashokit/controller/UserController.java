package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userService;
	
	@GetMapping("/")
	public String login(Model m) {
		User user = new User();
		user.setName("chinan");
		m.addAttribute("user", user);
		return "index";
	}
	
	@PostMapping("/login")
	public String saveUser(User user, Model model) {
		Boolean saveUser = userService.saveUser(user);
		if(saveUser) {
			model.addAttribute("msg", "User Saved");			
		}else {
			model.addAttribute("msg", "User not saved");
		}
		return "index";
	}
	
	

}
