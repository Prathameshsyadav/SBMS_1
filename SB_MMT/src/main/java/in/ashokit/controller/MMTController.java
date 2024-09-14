package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.request.TickeRequest;
import in.ashokit.response.TicketResponse;
import in.ashokit.service.MMTService;

@Controller
public class MMTController {
	
	@Autowired
	private MMTService mmtService;
	
	@GetMapping("/")
	public String home(Model m) {
		TickeRequest req = new TickeRequest();
		m.addAttribute("req", req);
		return "index";
	}
	
	@GetMapping("/tickets")
	public String getAllTickets(Model m) {
		TicketResponse[] tickets = mmtService.getAllTicket();
		m.addAttribute("tickets", tickets);
		return "response";
	}
	
	@PostMapping("/addTicket")
	public String addTicket(@ModelAttribute("req") TickeRequest req, Model m) {
		TicketResponse ticketResponse = mmtService.addTicket(req);
		m.addAttribute("resp", ticketResponse);
		return "index";
	}
	
	@GetMapping("/processsingle")
	public String getSingleTicket(@RequestParam("email") String email, Model m) {
		TicketResponse[] ticketByEmail = mmtService.getTicketByEmail(email);
		m.addAttribute("resp", ticketByEmail);
		return "singleticket";
	}
	
	@GetMapping("/single")
	public String displaySingle(Model m) {
		TickeRequest req = new TickeRequest();
		m.addAttribute("req", req);
		return "single";
	}

}
