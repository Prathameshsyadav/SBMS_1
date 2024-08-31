package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordServices {

	@Autowired
	private MailService mailService;
	@Autowired
	private UserRepo userRepo;
	
	private Integer otp1;
	
	
	@Override
	public Boolean validateEmail(String email) {
		User user = userRepo.findByEmail(email);
		if (user != null) {
			otp1 = generateOtp();
			mailService.sendSimpleMail(email, "Otp for app", String.valueOf(otp1));
			return true;
		} else
			return false;
	}

	@Override
	public Boolean validateOtp(User user, String otp) {
		
		if (otp.equals(String.valueOf(otp1))) {
			return true;
		} else
			return false;
	}

	@Override
	public Boolean validatePassword(User user, String pwd1, String pwd2) {
		// TODO Auto-generated method stub
		if (pwd1.equals(pwd2)) {
			Integer userId = user.getId();
			Integer i = userRepo.updatePassword(userId, pwd2);
			if (i != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public  int generateOtp() {
	int	 otp1 = (int) (Math.random() * 900000) + 100000;
		return otp1;
	}

}
