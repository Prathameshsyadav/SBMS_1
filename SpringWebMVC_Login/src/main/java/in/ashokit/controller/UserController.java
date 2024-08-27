package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String displayRegisterPage(Model m) {
		m.addAttribute("msg", "Register here");
		return "registerPage";
	}
	
	@PostMapping("/registerUser")
	public String handleRegisterPage(User user, Model m) {
		User u = userService.registerUser(user);
		m.addAttribute("name", u.getName());
		return "loginPage";
	}
	
	@GetMapping("/loginPage")
	public String displayLoginPage(Model m) {
		m.addAttribute("msg", "Login here");
		return "loginPage";
	}
	
	@PostMapping("/dashboard")
	public String handleLoginPage(Model m, String email, String password) {
		User user = userService.loginUser(email, password);
		m.addAttribute("user",user);
		return "dashboard";
		
	}

}
