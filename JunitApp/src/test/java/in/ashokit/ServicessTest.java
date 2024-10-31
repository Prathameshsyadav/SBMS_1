package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.ashokit.services.Servicess;

@SpringBootTest
public class ServicessTest {
	
	@Autowired
	private Servicess servicess;
	
	@Test
	public void test_m1() {
		
		String m1 = servicess.m1();
		assertNotNull(m1);
		
	}
	
	@Test
	public void test_m2() {
		String m2 = servicess.m2();
		assertNotNull(m2);
	}

}
