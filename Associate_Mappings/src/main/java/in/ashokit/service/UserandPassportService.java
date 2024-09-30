package in.ashokit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Chocolate;
import in.ashokit.entity.Passport;
import in.ashokit.entity.People;
import in.ashokit.entity.Student;
import in.ashokit.entity.Subject;
import in.ashokit.entity.User;
import in.ashokit.repo.ChocolateRepo;
import in.ashokit.repo.PassportRepo;
import in.ashokit.repo.PeopleRepo;
import in.ashokit.repo.StudentRepo;
import in.ashokit.repo.SubjectRepo;
import in.ashokit.repo.UserRepo;

@Service
public class UserandPassportService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PassportRepo passportRepo;
	@Autowired
	private StudentRepo sturepo;
	@Autowired
	private SubjectRepo subRepo;
	@Autowired
	private ChocolateRepo choco;
	@Autowired
	private PeopleRepo peop;
	
	public void setUser() {
		User u = new User();
		u.setName("Prathamesh");
		
		Passport p = new Passport();
		p.setPassportCountryName("India");
		
		p.setUser(u);
		u.setPassport(p);
		
		userRepo.save(u);
		
		
	}
	
	public void setStudent() {
		Student s = new Student();
		s.setName("Avinash");
		
		Subject sub = new Subject();
		sub.setSubjectName("Maths");
		
		Subject sub1 = new Subject();
		sub1.setSubjectName("English");
		
		Subject sub2 = new Subject();
		sub2.setSubjectName("Physics");
		
		List<Subject>  a = new ArrayList<>();
		
		a.add(sub);
		a.add(sub1);
		a.add(sub2);
		
		System.out.println(a);
		
		sub.setStudent(s);
		sub1.setStudent(s);
		sub2.setStudent(s);
		s.setSubject(a);
		
		sturepo.save(s);
		
		

	}
	
	public void setPeople() {
	    People p = new People();
	    p.setName("Rohit");

	/*    People p2 = new People();
	    p2.setName("Raj");

	    People p3 = new People();
	    p3.setName("Rohan");*/

	    Chocolate c = new Chocolate();
	    c.setName("Dairy Milk");

	    Chocolate c2 = new Chocolate();
	    c2.setName("5 star");

	    Chocolate c3 = new Chocolate();
	    c3.setName("Perk");

	    Chocolate c4 = new Chocolate();
	    c4.setName("Munch");

	  
	    // Now associate the Chocolates with People
	    List<Chocolate> chocolates = Arrays.asList(c, c2, c3, c4);
	    p.setChocolate(chocolates);
	 

	  

	    // Persist the People entities
	    peop.save(p);
	  
	}

	

}
