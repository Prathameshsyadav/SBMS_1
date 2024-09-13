package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.MsgService;

@SpringBootApplication
public class SbRestConsumerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SbRestConsumerApplication.class, args);
		MsgService msgService = context.getBean(MsgService.class);
		msgService.getMessage();
	}

}
