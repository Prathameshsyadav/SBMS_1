package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Employee;

public interface EmpService {

	public Boolean saveEmployee(Employee e);

	public List<Employee> getEmployees();
	
	public void deleteEmp(Integer eid);

}
