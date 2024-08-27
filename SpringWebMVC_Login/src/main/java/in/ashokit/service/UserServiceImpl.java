package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo repo;

	public UserServiceImpl(UserRepo repo) {
		this.repo = repo;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		User user1 = repo.findByEmail(user.getEmail());
		if (user1 == null) {
			return repo.save(user);
		} else {
			throw new RuntimeException("User already registered");
		}

	}

	@Override
	public User loginUser(String email, String password) {
	    User user = repo.findByEmail(email);
	    if (user != null && user.getPassword().equals(password)) {
	        return user;
	    } else {
	        throw new RuntimeException("User not found or incorrect password");
	    }
	}

}
