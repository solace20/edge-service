package com.example.demo;

import com.example.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.nustaq.serialization.FSTConfiguration;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author: Solace
 * @Description: todo
 * @date: 2018/7/27
 * @CopyRight: lengbar.cn
 */
@Slf4j
public class RedissionTest {

    private RedissonClient client ;

    //@Before
    public void init(){
        Config config = new Config();
        //config.setTransportMode(TransportMode.EPOLL);
        config.useSingleServer().setAddress("redis://192.168.8.100:7000");
        client = Redisson.create(config);
    }

    @Test
    public void dohash(){
        RMap<String,User> map = client.getMap("solace");
        map.fastPut("123",new User("1","solace","333"));
        //map.putIfAbsent("123",new User("2","la","gou"));
        map.put("123",new User("2","la","gou"));

        User u1 = new User("3","shenzhen","changfen");
        User u2 = new User("4","wuhan","reganmian");
        RBucket<User> bucket = client.getBucket("anyObject");
        bucket.set(u2);
        boolean set1 = bucket.trySet(u1);
        System.out.println(set1);
        bucket.compareAndSet(u2,u1);
        System.out.println(bucket.get());
    }

    @Test
    public void GeospatialHolder(){
        RGeo<String> geo = client.getGeo("carl");
//        geo.add(new GeoEntry(13.361389, 38.115556, "NanShan"),
//                new GeoEntry(15.087269, 37.502669, "FuTian"),
//                new GeoEntry(15.087269, 37.502669, "Luohu"));
//        geo.addAsync(15.087269, 37.502669, "LongGang");
        Double distance = geo.dist("NanShan","LuoHu",GeoUnit.KILOMETERS);
        System.out.println(distance);
        geo.hashAsync("NanShan","FuTian");
        List<String> cities = geo.radius("FuTian", 70,GeoUnit.KILOMETERS,5);
        System.out.println(cities.toString());
    }

    @Test
    public void redisListener(){
        RTopic<User> topic = client.getTopic("anyTopic");
        topic.addListener((s, user) -> System.out.println("channel"+s+",message"+user));
        while (true){

        }
    }

    @Test
    public void redisListener2(){
        RTopic<User> topic = client.getTopic("anyTopic");
        topic.addListener((s, user) -> System.out.println("channel"+s+",message"+user));
        while (true){

        }
    }

    @Test
    public void redisPublish(){
        RTopic<User> topic = client.getTopic("anyTopic");
        long clientReceivedMessage = topic.publish(new User("2333","solace","hello,world"));
        System.out.println(clientReceivedMessage);
    }

    @Test
    public void testSerialization(){
        ///JDK序列化测试
        User user = new User("1","solace","password");
        long size = 0;
        long time1_start = System.currentTimeMillis();
        for (int i = 0;i<100000;i++){
            byte[] jdkSerialization = SerializationUtils.jdkSerialize(user);
            size+= jdkSerialization.length;
            SerializationUtils.jdkDeserialize(jdkSerialization);
        }
        long time1_end = System.currentTimeMillis();
        System.out.println("jdk序列化耗时:"+(time1_end-time1_start)+"   size:"+size);
        long time2_start = System.currentTimeMillis();
        long size2 = 0;
        for (int i = 0;i<100000;i++){
            byte[] jdkSerialization = SerializationUtils.serialize(user);
            size2+= jdkSerialization.length;
            SerializationUtils.unserialize(jdkSerialization);
        }
        long time2_end = System.currentTimeMillis();
        System.out.println("FST序列化耗时:"+(time2_end-time2_start)+"   size:"+size2);

    }
}
