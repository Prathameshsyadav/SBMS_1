package in.ashokit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmployeeRepository;

@Service
public class EmpServices {
	
	private EmployeeRepository empRepo;
	
	private static final int pageSize=3;

	public EmpServices(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public void m1(Employee e) {
		Employee employee = empRepo.save(e);
		System.out.println(employee);
	}
	
	public void m2() {
		List<Employee> all = empRepo.findAll();
		all.forEach(System.out::println);
	}
	
	public void m3() {
		List<Employee> emp = empRepo.findBySalaryLessThanEqual(60000.00);
		emp.forEach(System.out::println);
	}
	
	public void m4() {
		List<Employee> emp = empRepo.findByAddressAndSalaryGreaterThanEqual("Khadavli", 60000.00);
		emp.forEach(System.out::println);
	}
	
	public void m5() {
		List<Employee> emp = empRepo.findByName("Prathamesh");
		emp.forEach(System.out::println);
	}
	
	public void m6() {
		Integer i = empRepo.updateEmpSalary(200000.00, 2);
				Optional<Employee> byId = empRepo.findById(2);
		System.out.println(byId.get());
	}
	
	public void m7() {
		List<Employee> emp = empRepo.getEmpsSQL();
		emp.forEach(System.out::println);
	}
	
/*	public void getEmpDescSalary() {
		List<Employee> emp = empRepo.findAll(Sort.by("salary").descending());
		emp.forEach(System.out::println);
	}
	*/
	
	public void updateEmpAddress() {
		Integer i = empRepo.updateEmpAddress("Banglore", 2);
		Employee emp = empRepo.findById(2).get();
		System.out.println(emp);
	}
	
	public void m8() {
		String emp = empRepo.getEmpById(1);
		System.out.println(emp);
	}
	
	/*	public void getByPage(int pageNum) {
		PageRequest page = PageRequest.of(pageNum-1,pageSize);
		Page<Employee> emps = empRepo.findAll(page);
		emps.get().forEach(System.out::println);
	}
		
	public void getEmpswithQBE(Employee e) {
		Example<Employee> ex = Example.of(e);
		List<Employee> all = empRepo.findAll(ex);
		all.forEach(System.out::println);
		
	}*/
	
	public void getEmpByGenderAndSalary() {
		List<Employee> emp = empRepo.findByGenderAndSalaryGreaterThan("Male", 60000.00);
		emp.forEach(System.out::println);
	}

	public void sortByName() {
		List<Employee> all = empRepo.findAll(Sort.by("name").descending());
		all.forEach(System.out::println);	
	}
	
	public void getByPage(int pageNum) {
		PageRequest page = PageRequest.of(pageNum - 1, pageSize);
		Page<Employee> emps = empRepo.findAll(page);
		emps.forEach(System.out::println);
	}
	
	public void QBE(Employee e) {
		Example<Employee> of = Example.of(e);
		empRepo.findAll((of)).forEach(System.out::println);
		
	}
}
