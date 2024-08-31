package in.ashokit.services;

import in.ashokit.entity.User;
import jakarta.servlet.http.HttpSession;

public interface ForgotPasswordServices {
	
	public Boolean validateEmail(String email);
	
	public Boolean validateOtp(User user,String otp);
	
	public Boolean validatePassword(User user,String pwd1, String pwd2);

}
