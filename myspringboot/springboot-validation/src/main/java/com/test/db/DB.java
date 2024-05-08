package com.test.db;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class DB {

    public static ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();

    static{
        concurrentHashMap.put("A",1);
        concurrentHashMap.put("B",2);
        concurrentHashMap.put("C",3);

    }
}
