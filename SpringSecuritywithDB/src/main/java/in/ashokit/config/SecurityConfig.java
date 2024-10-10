package in.ashokit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.ashokit.service.CustomerService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private CustomerService customerService;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customerService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception{
		security.authorizeHttpRequests(req -> {
			req.requestMatchers("/register","/login")
			.permitAll()
			.anyRequest()
			.authenticated();
			
		}
		);
		
		return security.csrf(csrf -> csrf.disable()).build();
	}

}
