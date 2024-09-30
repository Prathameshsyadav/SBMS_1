package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Passport;
import in.ashokit.entity.User;
import in.ashokit.repo.PassportRepo;
import in.ashokit.repo.UserRepo;

@Service
public class UserandPassportService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PassportRepo passportRepo;
	
	public void setUser() {
		User u = new User();
		u.setName("Prathamesh");
		
		Passport p = new Passport();
		p.setPassportCountryName("India");
		
		p.setUser(u);
		u.setPassport(p);
		
		userRepo.save(u);
	}
	

}
