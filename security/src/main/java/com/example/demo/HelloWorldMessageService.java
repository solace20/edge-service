package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/26
 * @CopyRight: lengbar.cn
 */
@Component
public class HelloWorldMessageService {
    @PreAuthorize("hasRole('solace')")
    public Mono<String> findMessage(){
        return Mono.just("Hello world");
    }
}
