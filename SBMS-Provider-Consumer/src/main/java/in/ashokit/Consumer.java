package in.ashokit;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service
public class Consumer {
	
public static final String PROVIDER = "http://localhost:8080/greet";
	
	
	public void getMessage() {

		RestTemplate rt = new RestTemplate();
        // Create HttpHeaders and add Basic Auth Header
        HttpHeaders headers = new HttpHeaders();
        String auth = "root:root"; // Replace with your actual username and password
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);

        // Create HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the GET request with headers
        ResponseEntity<String> response = rt.exchange(PROVIDER, HttpMethod.GET, entity, String.class);
        
        // Print the response
        System.out.println(response.getBody());
		
	}

}
