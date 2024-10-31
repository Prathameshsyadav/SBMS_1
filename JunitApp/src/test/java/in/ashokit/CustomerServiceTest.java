package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import in.ashokit.dao.CustomerDao;
import in.ashokit.services.CustomerServices;

@SpringBootTest
@ExtendWith(value = {MockitoExtension.class})
public class CustomerServiceTest {
	
	@MockBean
	CustomerDao customerDao;
	@InjectMocks
	CustomerServices customerServices;
	
	@Test
	public void testGetName() {
		
		when(customerDao.findNameById(101)).thenReturn("Pratzzz");
		
		String name = customerServices.getName();
		
		assertNotNull(name);
		
		
		
	}

}
