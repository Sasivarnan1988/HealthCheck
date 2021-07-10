package com.user.info.controller;

import com.user.info.entity.Employee;
import com.user.info.entity.User;
import com.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getAll")
    public List<User> retrieveUser() {
        return userInfoService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        userInfoService.saveUser(user);
    }

    @GetMapping("/getFirstEmployee")
    public void retrieveFirstEmployee() {
        Employee employeeDetails = restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employee/1", Employee.class);
        System.out.println(employeeDetails.getData().get("employee_name").asText());
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}

