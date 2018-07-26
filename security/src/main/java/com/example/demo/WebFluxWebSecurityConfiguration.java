package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.server.SecurityWebFilterChain;


/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/23
 * @CopyRight: lengbar.cn
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@EnableGlobalMethodSecurity
public class WebFluxWebSecurityConfiguration {

    /**
     * 注入刚才我们定义的那个userdetails
     */
//    @Bean
//    ReactiveUserDetailsService usersDetailsService(){
//        return new MyUserDetailsService();
//    }


    @Bean
    public MapReactiveUserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("solace")
                .password("solace")
                .roles("USER")
                .build();
        UserDetails solaceDetails = User.withDefaultPasswordEncoder()
                .username("hao123")
                .password("123")
                .roles("solace")
                .build();
        return new MapReactiveUserDetailsService(userDetails,solaceDetails);
    }

    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity httpSecurity)throws Exception{
        return httpSecurity
                .authorizeExchange()
                .anyExchange().permitAll()
                .and()
                .httpBasic().and()
                .build();
    }
}
