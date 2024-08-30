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
import in.ashokit.services.UserService;
import in.ashokit.services.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	//@Autowired
//	private ContactServices contactService;

	/*@GetMapping("/")
	public String registerPage(Model m) {
		m.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String handleRegisterPage(User u, HttpServletRequest request) {
		Boolean isSave = userService.saveUser(u);
		HttpSession session = request.getSession(true);
		session.setAttribute("user", u);
		System.out.println(u);
	//	m.addAttribute("user", new User());
		/*if (isSave) {
			m.addAttribute("smsg", "User Saved");
		} else {
			m.addAttribute("emsg", "User not Saved");
		}*//*
		return "login";
	}

	@GetMapping("/login")
	public String loginPage(Model m) {
		m.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/dashboard")
	public String handleLogin(Model m, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		//session.setAttribute("user", u);
		User u = (User) session.getAttribute("user");
		Boolean isLoginSuccess = userService.loginUser(u.getEmail(), u.getPassword());
			System.out.println(u);
		if (isLoginSuccess) {
			m.addAttribute("contact", new Contact());
			return "dashboard";
		} else {
			m.addAttribute("emsg", "Login Failed");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		session.invalidate();

		return "redirect:/login";
	}
	
	@GetMapping("/contact")
	public String viewContactForm(Model m,  HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		m.addAttribute("contact", new Contact());	
		return "dashboard";
	}

	@PostMapping("/addContact")
	public String handleContact(User u,Contact contact, Model m, HttpServletRequest request) {
		//System.out.println(u);
		//contact.setUser(u);
		Boolean c = contactService.addContact(contact,u);
		System.out.println(u);
		HttpSession session = request.getSession(false);
		//session.setAttribute("user", u)
		if (c) {
			m.addAttribute("msg", "Contact saved");
		} else {
			m.addAttribute("msg", "Contact Not saved");
		}
		return "dashboard";

	}
	
	@GetMapping("/viewcontact")
	public String viewContact(HttpServletRequest req, Model m) {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		List<Contact> contact = contactService.getUserContact(u);
		//System.out.println(u);
		m.addAttribute("contact", contact);
		return "contactDetails";
	}*/
	
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
	     /*   if (loggedInUser) {
	            session.setAttribute("user", user);
	            return "dashboard";
	        }*/
	        if (u != null) {
				m.addAttribute("contact", new Contact());
				session.setAttribute("user", u);
				return "dashboard";
			} else {
				m.addAttribute("emsg", "Login Failed");
				return "login";
			}
	        //return "login";
	    }

	    @GetMapping("/logout")
	    public String logoutUser(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	    
	    
	}

