package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Boolean saveUser(User user) {
		User save = userRepo.save(user);
		return save.getId()!= null;
		}

}
