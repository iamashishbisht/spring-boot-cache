package org.example.controller;

import org.example.model.InputModel;
import org.example.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;
    @GetMapping("/get")
    public String getData(@RequestBody InputModel input){
        return redisTestService.getData(input.getId());
    }

    @PostMapping("/save")
    public String saveData(@RequestBody InputModel input){
        return redisTestService.saveData(input.getId(), input.getData());
    }

    @PostMapping("/delete")
    public String deleteData(@RequestBody InputModel input){
        return redisTestService.deleteData(input.getId());
    }
}
