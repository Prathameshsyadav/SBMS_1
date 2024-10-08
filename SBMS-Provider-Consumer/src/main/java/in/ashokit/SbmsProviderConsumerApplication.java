package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbmsProviderConsumerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SbmsProviderConsumerApplication.class, args);
		
		Consumer bean = run.getBean(Consumer.class);
		bean.getMessage();
	}

}
