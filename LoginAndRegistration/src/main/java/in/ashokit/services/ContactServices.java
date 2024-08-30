package in.ashokit.services;

import java.util.List;
import java.util.Set;

import in.ashokit.entity.Contact;
import in.ashokit.entity.User;

public interface ContactServices {
	
	public List<Contact> getUserContact(User user);
	
	public Boolean addContact(Contact c, User u);
	
	

	
}
