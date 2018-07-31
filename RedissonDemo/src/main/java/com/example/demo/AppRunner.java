package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/31
 * @CopyRight: lengbar.cn
 */
@Slf4j
//@Component
public class AppRunner implements CommandLineRunner{

    private final UserRepository userRepository;

    public AppRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("isbn-1234 -->" + userRepository.getUserById("isbn-1234"));
        log.info("isbn-1234 -->" + userRepository.getUserById("isbn-1234"));
        log.info("isbn-1234 -->" + userRepository.getUserById("isbn-1234"));
        log.info("isbn-1234 -->" + userRepository.getUserById("isbn-1234"));
    }
}
