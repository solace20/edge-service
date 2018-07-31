package com.example.demo;

import com.example.demo.pojo.User;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
@RestController
public class RedissonDemoApplication {

	@Bean(destroyMethod = "shutdown")
	RedissonClient redisson(@Value("classpath:/redisson.yaml")Resource configFile) throws IOException {
		Config config = Config.fromYAML(configFile.getInputStream());
		return Redisson.create(config);

	}

	@Bean
	CacheManager cacheManager(RedissonClient redissonClient){
		return new RedissonSpringCacheManager(redissonClient,"classpath:/spring-cache.yaml");
	}

	public static void main(String[] args) {
		SpringApplication.run(RedissonDemoApplication.class, args);
	}


}
