package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.core.publisher.Flux;
import reactor.ipc.netty.NettyContext;
import reactor.ipc.netty.http.server.HttpServer;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@EnableWebFlux
@ComponentScan
public class SecurityApplication {

	@Value("${server.port:8080}")
	private int port = 8080;

	public static void main(String[] args) throws Exception {
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecurityApplication.class)) {
			context.getBean(NettyContext.class).onClose().block();
		}
	}

	@Profile("default")
	@Bean
	public NettyContext nettyContext(ApplicationContext context) {
		HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context)
				.build();
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		HttpServer httpServer = HttpServer.create("localhost", this.port);
		return httpServer.newHandler(adapter).block();
	}
//	@Bean
//	public HttpHandler httpHandler(RouterFunction<ServerResponse> routes, WebFilter springSecurityFilterChain) {
//		HandlerStrategies handlerStrategies = HandlerStrategies.builder()
//				.webFilter(springSecurityFilterChain)
//				.build();
//
//		return RouterFunctions.toHttpHandler(routes, handlerStrategies);
//	}

//	@Bean
//	public RouterFunction<?> routes(){
//		return RouterFunctions.route(GET("/hello"),r -> ok().body(Flux.just("hello webflux security!"),String.class))
//				.andRoute(GET("message"),);
//	}

}

