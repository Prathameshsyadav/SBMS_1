package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmpService {
	
	private EmployeeRepo empRepo;
	
	private MailService mailService;

	public EmployeeService(EmployeeRepo empRepo, MailService mailService) {

		this.empRepo = empRepo;
		this.mailService = mailService;
	}

	@Override
	public Boolean saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		empRepo.save(e);
		return e.getId()!=null;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> emp = empRepo.findAll();
		return emp;
	}

	@Override
	public void deleteEmp(Integer eid) {
		empRepo.deleteById(eid);
		
	}
	
	public void sendMailToUser(String to, String subject, String body) {
		mailService.sendSimpleEmail(to, subject, body);
	}
	
	public void sendMimeMessageToUser(String to, String subject, String body) {
		mailService.sendMimeEmail(to, subject, body);
	}
	

}
