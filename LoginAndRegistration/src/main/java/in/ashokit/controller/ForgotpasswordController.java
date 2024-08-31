package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.services.ForgotPasswordServiceImpl;
import in.ashokit.services.MailService;
import in.ashokit.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotpasswordController {

	@Autowired
	ForgotPasswordServiceImpl forgotpasswordService;
	@Autowired
	UserService userService;
	@Autowired
	MailService mailService;
	
	@GetMapping("/forgotpassword")
	public String displayForgotPasswordPage() {
		return "forgotPasswordPage";
	}
	
	@PostMapping("/forgotpassword")
	public String handleEmail(String email, Model m, HttpSession session) {
		User user = userService.findByEmail(email);
		session.setAttribute("user", user);
		Boolean validateEmail = forgotpasswordService.validateEmail(email);
		//int otp = ForgotPasswordServiceImpl.generateOtp();
		
		//boolean sendSimpleMail = mailService.sendSimpleMail(email, "Simple mail service", "Your OTP is "+otp);
		if(validateEmail) {
			return "otpPage";
		} else {
			m.addAttribute("msg", "Invalid Email");
			return "forgotPasswordPage";
		}
	}
	
	@GetMapping("/otp")
	public String displayOtpPage() {
		return "otpPage";
	}
	
	@PostMapping("/otp")
	public String handleOtpPage(String otp,Model m,HttpSession s) {
		User user = (User) s.getAttribute("user");
		System.out.println(user.getId());
		Boolean validateOtp = forgotpasswordService.validateOtp(user, otp);
		if(validateOtp) {
			return "passwordPage";
		}else {
			m.addAttribute("msg", "Invalid otp");
			return "otpPage";
		}
	}
	
	@GetMapping("/password")
	public String viewPasswordPage() {
		return "passwordPage";
	}
	
	@PostMapping("/resetPassword")
	public String handlePasswordPage(String pwd1, String pwd2, Model m, HttpSession s) {
		User user = (User) s.getAttribute("user");
		Boolean validatePassword = forgotpasswordService.validatePassword(user, pwd1, pwd2);
		if(validatePassword) {
			m.addAttribute("msg", "password updated successfully");
			return "login";
		}else {
			m.addAttribute("msg", "passwords not matched");
			return "passwordPage";
		}
	}
}
