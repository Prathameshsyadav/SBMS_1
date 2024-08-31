package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import in.ashokit.entity.Contact;
import in.ashokit.entity.User;
import in.ashokit.services.ContactServices;
import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
	
	@Autowired
	private ContactServices contactService;
	
	
	  @GetMapping("/contact")
	    public String showContactForm(Model model, HttpSession session) {
	        model.addAttribute("contact", new Contact());
	        return "dashboard";
	    }

	    @PostMapping("/addContact")
	    public String addContact(@ModelAttribute Contact contact, HttpSession session, Model m) {
	        User user = (User) session.getAttribute("user");
	        Boolean contact2 = contactService.addContact(contact, user);
	        if(contact2) {
	        	m.addAttribute("msg", "Contact saved");
	        }else {
	        	m.addAttribute("emsg", "Please login first");
	        	return "login";
	        }
	        return "dashboard";
	    }

	    @GetMapping("/viewcontact")
	    public String viewContacts(Model model, HttpSession session) {
	        User user = (User) session.getAttribute("user");
	        List<Contact> contacts = contactService.getUserContact(user);
	        if(contacts != null) {
	        	model.addAttribute("contact", contacts);
		        return "contactDetails";
	        }else {
	        	model.addAttribute("emsg", "Please login first");
	        	return "login";
	        }
	        
	    }

}
