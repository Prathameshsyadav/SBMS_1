package in.ashokit.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.request.TickeRequest;
import in.ashokit.response.TicketResponse;

@Service
public class MMTService {
	
	private static final String REQUEST_URL = "https://www.classes.ashokit.in/tickets";
	private static final String ADD_TICKET_URL = "https://www.classes.ashokit.in/ticket";
	private static final String GET_TICKET = "https://www.classes.ashokit.in/tickets/";
	
	
	public TicketResponse[] getAllTicket() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<TicketResponse[]> forEntity = rt.getForEntity(REQUEST_URL, TicketResponse[].class);
		TicketResponse[] body = forEntity.getBody();
		return body;
	}
	
	public TicketResponse addTicket(TickeRequest req) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<TicketResponse> postForEntity = rt.postForEntity(ADD_TICKET_URL, req, TicketResponse.class);
		TicketResponse body = postForEntity.getBody();
		return body;
	}
	
	public TicketResponse[] getTicketByEmail(String email) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<TicketResponse[]> forEntity = rt.getForEntity(GET_TICKET+email, TicketResponse[].class);
		return forEntity.getBody();
	}
	
	
	

}
