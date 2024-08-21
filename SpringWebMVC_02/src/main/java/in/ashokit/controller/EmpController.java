package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Employee;
import in.ashokit.services.EmpService;

@Controller
public class EmpController {
	
	private EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/getEmp")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView();
		List<Employee> employees = empService.getEmployees();
		mav.addObject("emp", employees);
		mav.setViewName("index");
		return mav;
	}
	
	

}
