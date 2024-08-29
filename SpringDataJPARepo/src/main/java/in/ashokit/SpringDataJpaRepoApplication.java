package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Employee;
import in.ashokit.services.EmpServices;

@SpringBootApplication
public class SpringDataJpaRepoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaRepoApplication.class, args);
		EmpServices bean = context.getBean(EmpServices.class);
		
	/*	Employee e = new Employee();
		e.setId(1);
		e.setName("Nanu");
		e.setAddress("Ambernath");
		e.setSalary(25000.00);
		
		bean.m1(e);*/
		
	//-----------------------------------------------------
		
		bean.m2();
		
	//-----------------------------------------------------
		
	//	bean.m3();
		
		//-----------------------------------------------------
		
	//	bean.m4();
		
	// bean.m5();	
		
		
		
	//	bean.m6();
		
		
	//	bean.m7();
		
	//	bean.getEmpDescSalary();
		
	//	bean.updateEmpAddress();
		
	//	bean.m8();
		
		bean.getByPage(3);
	/*	
		Employee emp = new Employee();
		emp.setAddress("Banglore");
		
		Employee emp1 = new Employee();
		emp1.setName("Rohit");
		
		bean.getEmpswithQBE(emp);
		bean.getEmpswithQBE(emp1);*/
		
		
		//bean.getEmpByGenderAndSalary();
		
	//	bean.sortByName();
		
	//	bean.getByPage(2);
		
		Employee e = new Employee();
		e.setAddress("Khadavli");
		
		
		bean.QBE(e);
	}

}
