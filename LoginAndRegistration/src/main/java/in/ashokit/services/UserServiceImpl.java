package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Boolean saveUser(User user) {
		User u = userRepo.save(user);
		return u.getId()!=null;
	}

	@Override
	public Boolean loginUser(String email, String password) {
		User user = userRepo.findByEmail(email);
		//System.out.println(user);
		if(user.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	

	

}
