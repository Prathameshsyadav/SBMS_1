package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.WebService;

@SpringBootApplication
public class SbmsWebclientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SbmsWebclientApplication.class, args);
		WebService bean = run.getBean(WebService.class);
		bean.getQuote2();
	}

}
