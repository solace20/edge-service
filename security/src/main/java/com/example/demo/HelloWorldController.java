package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/26
 * @CopyRight: lengbar.cn
 */
@RestController
public class HelloWorldController {

    private final HelloWorldMessageService service;

    public HelloWorldController(HelloWorldMessageService service) {
        this.service = service;
    }
    @GetMapping("/message")
    public Mono<String> message(){
        return this.service.findMessage();
    }
}
