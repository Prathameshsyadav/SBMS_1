package in.ashokit.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String to, String subject, String body) {
		SimpleMailMessage s = new SimpleMailMessage();
		s.setTo(to);
		s.setSubject(subject);
		s.setText(body);
		
		mailSender.send(s);	
	}
	
	
	public void sendMimeEmail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		
		
		try {
			MimeMessageHelper m = new MimeMessageHelper(message,true);
			m.setTo(to);
			m.setSubject(subject);
			m.setText(body, true);
			m.addAttachment("Ajax.txt", new File("D:\\Ashok it\\notes\\Ajax.txt"));
			mailSender.send(message);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
