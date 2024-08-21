package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String index(@RequestParam("eid") Integer eid, Model m) {
		Employee employee = empService.getEmployee(eid);
		System.out.println(employee);
		m.addAttribute("name", employee.getName());
		m.addAttribute("email", employee.getEmail());
		m.addAttribute("phNo", employee.getPhNo());
		m.addAttribute("eid", eid);
		return "edit";
	}
	
	@GetMapping("/")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
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
			//empService.sendMimeMessageToUser(emp.getEmail(), "Test", "<h1 style='color:red'>This is the test email</h1>");
		mav.setViewName("index");
		return mav;
	}
	
	//@GetMapping("/submit")
	@PostMapping("/update/{eid}")
	public ModelAndView updateForm(@PathVariable Integer eid, Employee emp) {
		ModelAndView mav = new ModelAndView();
		System.out.println(eid);
		if(eid != null) {
			//empService.updateEmp(emp.getId());
			System.out.println(emp);
			empService.saveEmployee(emp);
		}else {
			Boolean saveEmployee = empService.saveEmployee(emp);
			if(saveEmployee) {
				 mav.addObject("smsg", "Employee saved");
			}else {
				 mav.addObject("emsg", "Employee Not saved");
			}
		}	
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
