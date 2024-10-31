package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.CustomerDao;

@Service
public class CustomerServices {
	
	@Autowired
	CustomerDao customerDao;
	
	public String getName() {
		String name = customerDao.getClass().getName();
		System.out.println(name);
		
		String nameById = customerDao.findNameById(101);
		return nameById;
	}

}
