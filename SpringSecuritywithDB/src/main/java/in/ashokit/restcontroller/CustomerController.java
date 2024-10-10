package in.ashokit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo repo;
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody Customer customer){
		String encode = encoder.encode(customer.getPassword());
		customer.setPassword(encode);
		Customer save = repo.save(customer);
		return new ResponseEntity<String>("Customer saved", HttpStatus.CREATED);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer customer) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword());
		try {
			Authentication authenticate = manager.authenticate(token);
			if(authenticate.isAuthenticated()) {
				return new ResponseEntity<String>("Login Successfull", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return new ResponseEntity<String>("Login Failed", HttpStatus.FORBIDDEN);
		
	}

}
