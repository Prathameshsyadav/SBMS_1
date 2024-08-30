package in.ashokit.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Contact;
import in.ashokit.entity.User;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
	
	public List<Contact> findByUser(User user);
	

}
