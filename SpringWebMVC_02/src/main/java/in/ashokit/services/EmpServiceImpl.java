package in.ashokit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmployeeRepository;
@Service
public class EmpServiceImpl implements EmpService {
	
	private EmployeeRepository empRepo;
	
	public EmpServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> all = empRepo.findAll();
		return all;
	}

}
