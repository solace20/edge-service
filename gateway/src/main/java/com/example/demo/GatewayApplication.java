package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

//	@Autowired
//	private DiscoveryLocatorProperties properties;

//	@Bean
//	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient){
//		properties.setEnabled(true);
//		return new DiscoveryClientRouteDefinitionLocator(discoveryClient,properties);
//	}

//	@Bean
//	public RouteLocator customRoutes(RouteLocatorBuilder builder){
//		return builder.routes()
//				.route(r -> r.path("/customers").and().uri("lb://provider"))
//				.build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
