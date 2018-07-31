package com.example.demo;

import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/31
 * @CopyRight: lengbar.cn
 */
@RestController
public class SimpleController {

    @Autowired(required = false)
    private UserRepository repository;

    @GetMapping(value = "cache")
    public Mono<User> getCache(){

        return Mono.just(repository.getUserById("1"));
    }

    @GetMapping(value = "removeCache")
    public void removeCache(){
        repository.RemoveCache("1");
    }

    @GetMapping(value = "1",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> springCacheTest(){
        List<User> users = new ArrayList<>();
        users.add(new User("1","2","3"));
        users.add(new User("2","2","3"));
        users.add(new User("3","2","3"));
        return Flux.fromStream(users.parallelStream()).delayElements(Duration.ofSeconds(1));
    }
}
