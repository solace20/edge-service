package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
public class ProviderApplication {
	@Bean
	ApplicationRunner init(CustomerRepository cr){
		return args -> cr.deleteAll()
				.thenMany(Flux.just("A","B","C").map(l -> new Customer(null,l)).flatMap(cr::save))
				.thenMany(cr.findAll())
				.subscribe(System.out::println);
	}

	@Bean
	RouterFunction<?> routes (CustomerRepository cr){
		cr.insert(new Customer(123,"solace"));
		return route(GET("/customers"), r -> ok().body(cr.findAll(),Customer.class))
				.andRoute(GET("/customers/{id}"),r -> ok().body(cr.findById(r.pathVariable("id")),Customer.class))
				.andRoute(GET("/delay"),r -> ok().body(Flux.just("hello world").delayElements(Duration.ofSeconds(10)),String.class));
		//.andRoute(GET("/add",r -> ok().body())));
	}
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
}

interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer{
	@Id
	private Integer id;
	private String name;
}
