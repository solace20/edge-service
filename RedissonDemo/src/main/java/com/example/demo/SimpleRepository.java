package com.example.demo;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/31
 * @CopyRight: lengbar.cn
 */
@Service
@Slf4j
public class SimpleRepository implements UserRepository{


    @Override
    @Cacheable("books1")
    public User getUserById(String uid) {
        simulateSlowService();
        log.info("load from extener");
        return new User("1","2","3");
    }

    @CacheEvict(value = "books1",key = "#uid")
    @Override
    public void RemoveCache(String uid) {

    }



    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
