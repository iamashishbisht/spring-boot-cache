package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisTestService {

    @Autowired
    RedisDataSercice redisDataSercice;

    public String getData(int id) {
        System.out.println("getData service method");
        return redisDataSercice.getDataFromDb(id);
    }

    public String saveData(int id, String data) {
        System.out.println("saveData service method");
        return redisDataSercice.saveDataToDb(id, data);
    }

    public String deleteData(int id) {
        System.out.println("deleteData service method");
        return redisDataSercice.deleteDataToDb(id);
    }
}
