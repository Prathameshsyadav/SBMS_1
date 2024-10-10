package in.ashokit.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@Service
public class CustomerService implements UserDetailsService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerRepo.findByEmail(username);
		
		Collection<GrantedAuthority> authorities = customer.getRole()
		.stream()
		.map(role -> new SimpleGrantedAuthority(role))
		.collect(Collectors.toList());
		
		return new User(customer.getEmail(), customer.getPassword(),authorities );
		
	}

}
