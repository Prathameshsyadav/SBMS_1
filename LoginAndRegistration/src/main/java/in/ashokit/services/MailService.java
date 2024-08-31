package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	UserRepo userRepo;
	
	 
	
	public boolean sendSimpleMail(String to, String subject, String body) {
		User user = userRepo.findByEmail(to);
		if(user != null) {
			SimpleMailMessage s = new SimpleMailMessage();
			s.setTo(to);
			s.setSubject(subject);
			s.setText(body);
			
			mailSender.send(s);
			return true;
		}else {
			return false;
		}
		
	}
	

	
	

}
