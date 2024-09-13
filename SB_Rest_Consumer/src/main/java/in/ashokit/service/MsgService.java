package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MsgService {
	
	public static final String PROVIDER = "https://api.restful-api.dev/objects/";
	
	
	public void getMessage() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> forEntity = rt.getForEntity(PROVIDER, String.class);
		System.out.println("The status code is "+forEntity.getStatusCode());
		System.out.println("The body contains "+forEntity.getBody());
	}

}
