package com.bicovski.user.controller;

import com.bicovski.user.VO.ResponseTemplateVO;
import com.bicovski.user.entity.User;
import com.bicovski.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("userController: saveUser method");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("userController: getUserWithDepartment method");
        return userService.getUserWithDepartment(userId);
    }
}
