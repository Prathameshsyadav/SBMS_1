package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
	

}
