package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {

	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "m2", name = "m1")
	public String m1() {
		System.out.println("----------Get data from Redis cached server---------");
		int i = 10/0;
		return "m1() called from redis";
	}

	public String m2(Throwable t) {
		System.out.println("Get data from Database");
		return "m2() called from db";
	}

}
