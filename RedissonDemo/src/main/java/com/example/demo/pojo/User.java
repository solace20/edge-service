package com.example.demo.pojo;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/27
 * @CopyRight: lengbar.cn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private String id;
    private String name;
    private String password;
}
