package com.example.demo;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/26
 * @CopyRight: lengbar.cn
 */
public class MyUserDetailsService implements ReactiveUserDetailsService{
    //在这里定义user的获取方式

    /**
     * 你可以在这里注入一个dao层,service层代码,通过这些来获取userdetails
     *
     */

    @Override
    public Mono<UserDetails> findByUsername(String s) {
        return null;
    }
}
