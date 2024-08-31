package in.ashokit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(User user) {
		User u = userRepo.save(user);
		return u;
	}

	@Override
	public User loginUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		//System.out.println(user);
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}else {
				return null;
			}
		}else {
			return null;
		}
		
	}
	

	
	
	

	

}
