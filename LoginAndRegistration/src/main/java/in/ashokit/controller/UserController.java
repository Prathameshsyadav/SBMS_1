package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String registerPage(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String handleRegisterPage(User u, Model m) {
		Boolean isSave = userService.saveUser(u);
		if(isSave) {
			m.addAttribute("smsg", "User Saved");
		}else {
			m.addAttribute("emsg", "User not Saved");
		}
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/dashboard")
	public String handleLogin(String email, String password, Model m, HttpServletRequest request) {
		Boolean isLoginSuccess = userService.loginUser(email, password);
		
		if(isLoginSuccess) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", email);
			return "dashboard";
		}else {
			m.addAttribute("emsg", "Login Failed");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String attribute = (String) session.getAttribute("user");
		System.out.println(attribute);

		session.invalidate();
		
		return "redirect:/login";
	}
}
