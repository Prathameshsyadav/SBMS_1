package in.ashokit.services;

import in.ashokit.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User loginUser(String email, String password);
	
	public User findByEmail(String email);
	

}
