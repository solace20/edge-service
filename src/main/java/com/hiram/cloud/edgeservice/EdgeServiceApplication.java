package com.hiram.cloud.edgeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableDiscoveryClient
public class EdgeServiceApplication {

	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder){
		return builder.routes()
					.route(r -> r.path("/java/**").filters(f -> f.stripPrefix(1)).uri("http://httpbin.org"))

				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}
}
