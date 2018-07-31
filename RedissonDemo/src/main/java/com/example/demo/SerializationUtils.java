package com.example.demo;

import lombok.NoArgsConstructor;
import org.nustaq.serialization.FSTConfiguration;

import java.io.*;
import java.util.Objects;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/28
 * @CopyRight: lengbar.cn
 */
@NoArgsConstructor
public class SerializationUtils {

    static FSTConfiguration configuration = FSTConfiguration.createStructConfiguration();

    public static byte[] serialize(Object obj){
        return configuration.asByteArray(obj);
    }

    public static Object unserialize(byte[] sec){
        return configuration.asObject(sec);
    }

    public static byte[] jdkSerialize(Object obj){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object jdkDeserialize(byte[] bits){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bits);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
