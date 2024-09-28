package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Service
public class WebService {

	public static final String URL = "http://classes.ashokit.in:8084/tickets";

	// SYNC
	public void getQuote1() {

		WebClient webClient = WebClient.create();
		Mono<String> bodyToMono = webClient.get().uri(WebService.URL).retrieve().bodyToMono(String.class);
		String block = bodyToMono.block();
		System.out.println(block);
	}
	
	//Async
	public void getQuote2() {

		WebClient webClient = WebClient.create();

		System.out.println("Method started--------------------------started-----------------");

		Disposable subscribe = webClient.get().uri(WebService.URL).retrieve().bodyToMono(String.class)
				.subscribe(response -> System.out.println(response));

		System.out.println("Method ended ==----------------------------ended----------------");

	}
}
