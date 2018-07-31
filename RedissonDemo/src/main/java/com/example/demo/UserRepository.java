package com.example.demo;

import com.example.demo.pojo.User;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/31
 * @CopyRight: lengbar.cn
 */
public interface UserRepository {
    User getUserById(String uid);
    void RemoveCache(String uid);
}
