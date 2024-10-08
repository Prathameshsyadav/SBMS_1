package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//findByXXX
	public List<Employee> findBySalaryLessThanEqual(Double salary);
	
	public List<Employee> findByAddressAndSalaryGreaterThanEqual(String address, Double Salary);
	
	public List<Employee> findByName(String name);
	
	
	//CustomQuery
	@Transactional
	@Modifying
	@Query("UPDATE Employee set salary=:salary where id=:id")  //HQL
	public int updateEmpSalary(Double salary,Integer id );
	
	@Query(value = "select * from employee", nativeQuery = true)  //SQL
	public List<Employee> getEmpsSQL();
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE employee set address=:address where id=:id", nativeQuery = true)
	public int updateEmpAddress(String address, Integer id);
	
	@Query(value = "SELECT address FROM employee  WHERE id = :id", nativeQuery = true)
	public String getEmpById(Integer id); 
	
	public List<Employee> findByGenderAndSalaryGreaterThan(String gender, Double salary);
	
	

}
