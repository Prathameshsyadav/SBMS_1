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
	    public String addContact(@ModelAttribute Contact contact, HttpSession session) {
	        User user = (User) session.getAttribute("user");
	        //System.out.println(user);
	        contactService.addContact(contact, user);
	        return "dashboard";
	    }

	    @GetMapping("/viewcontact")
	    public String viewContacts(Model model, HttpSession session) {
	        User user = (User) session.getAttribute("user");
	        System.out.println(user);
	        List<Contact> contacts = contactService.getUserContact(user);
	        model.addAttribute("contact", contacts);
	        return "contactDetails";
	    }

}
