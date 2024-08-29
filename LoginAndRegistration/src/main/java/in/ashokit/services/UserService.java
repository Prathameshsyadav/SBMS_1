package in.ashokit.services;

import in.ashokit.entity.User;

public interface UserService {
	
	public Boolean saveUser(User user);
	
	public Boolean loginUser(String email, String password);

}
