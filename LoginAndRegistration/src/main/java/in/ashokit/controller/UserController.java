package in.ashokit.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.Contact;
import in.ashokit.entity.User;
import in.ashokit.services.ContactServices;
import in.ashokit.services.MailService;
import in.ashokit.services.UserService;
import in.ashokit.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, HttpSession session) {
		userService.saveUser(user);
		session.setAttribute("user", user);
		return "login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/dashboard")
	public String loginUser(@ModelAttribute User user, HttpSession session, Model m) {
		User u = userService.loginUser(user.getEmail(), user.getPassword());
		/*
		 * if (loggedInUser) { session.setAttribute("user", user); return "dashboard"; }
		 */
		if (u != null) {
			m.addAttribute("contact", new Contact());
			session.setAttribute("user", u);
			return "dashboard";
		} else {
			m.addAttribute("emsg", "Login Failed");
			return "login";
		}
		// return "login";
	}

	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
