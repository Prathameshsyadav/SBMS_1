package in.ashokit.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.entity.User;
import in.ashokit.repo.ContactRepo;
import in.ashokit.repo.UserRepo;

@Service
public class ContactServiceImpl implements ContactServices {
	
	@Autowired
	private ContactRepo contactRepo;
	@Autowired
	private UserRepo userRepository;

	@Override
	public List<Contact> getUserContact(User user) {
		
		List<Contact> contacts = contactRepo.findByUser(user);
		System.out.println(contacts);
		return contacts;
	}

	@Override
	public Boolean addContact(Contact contact, User user) {
		// TODO Auto-generated method stub
		User managedUser = userRepository.findById(user.getId()).orElseThrow();
        contact.setUser(managedUser);
		 Contact save = contactRepo.save(contact);
		 return save.getCid() != null;
	}


}
