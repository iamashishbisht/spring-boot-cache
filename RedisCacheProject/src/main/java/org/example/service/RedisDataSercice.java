package org.example.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RedisDataSercice {

    Map<Integer,String> cacheMap = new HashMap<Integer, String>();

    @Cacheable(value = "dbCache", key = "#i")
    public String getDataFromDb(int i){
        System.out.println("getDataFromDb");
        String s = cacheMap.get(i);
        if(s == null){
            throw new RuntimeException("data is not available for given key");
        }
        printData();
        return s;
    }

    private void printData() {
        System.out.println("data available as -> "+ cacheMap);
    }

    public String saveDataToDb(int i, String d){
        System.out.println("saveDataToDb");
        try {
            String s = cacheMap.put(i, d);
        }catch (Exception e){
            throw new RuntimeException("data can't be saved for given key");
        }
        printData();
        return cacheMap.get(i);
    }

    @CacheEvict(value = "dbCache", key = "#id")
    public String deleteDataToDb(int id) {
        System.out.println("getDataFromDb");
        String s = cacheMap.remove(id);
        if(s == null){
            throw new RuntimeException("data is not available for given key");
        }
        printData();
        return s;
    }
}
