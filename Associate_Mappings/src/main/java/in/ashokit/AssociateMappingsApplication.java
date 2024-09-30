package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.UserandPassportService;

@SpringBootApplication
public class AssociateMappingsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(AssociateMappingsApplication.class, args);
		UserandPassportService bean = run.getBean(UserandPassportService.class);
		//bean.setUser();
		
		bean.setStudent();
	}

}
