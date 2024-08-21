package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import in.ashokit.entity.Employee;
import in.ashokit.service.EmpService;
import in.ashokit.service.EmployeeService;

@Controller
public class EmpController {
	
	private EmployeeService empService;
	
	public EmpController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/employee")
	public String index(Model m) {
		m.addAttribute("msgg", "Index page is loaded with Model");
		return "index";
	}
	
	@GetMapping("/")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	//@GetMapping("/submit")
	@PostMapping("/submit")
	public ModelAndView handleForm(Employee emp) {
		ModelAndView mav = new ModelAndView();
		Boolean saveEmployee = empService.saveEmployee(emp);
		if(saveEmployee) {
			 mav.addObject("smsg", "Employee saved");
		}else {
			 mav.addObject("emsg", "Employee Not saved");
		}
		//empService.sendMailToUser(emp.getEmail(), "Test", "Mail sent via simple mail message");
		empService.sendMimeMessageToUser(emp.getEmail(), "Test", "<h1 style='color:red'>This is the test email</h1>");
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/empss")
	public ModelAndView displayList() {
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = empService.getEmployees();
		//System.out.println(employees);
		mav.addObject("emps", employees);
		mav.setViewName("data");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteEmployee(Integer eid) {
		empService.deleteEmp(eid);
		
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = empService.getEmployees();
		//System.out.println(employees);
		mav.addObject("msg", "Employee got deleted");
		mav.addObject("emps", employees);
		mav.setViewName("data");
		return mav;
	}
	


}
