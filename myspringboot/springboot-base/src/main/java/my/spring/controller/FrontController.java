package my.spring.controller;

import my.spring.bean.User;
import my.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:46
 * @Version: 1.0
 **/
@RestController
public class FrontController {

    @Autowired
    private UserService userService;

    @GetMapping("getUser")
    public User getUser(@RequestParam(required = true) String index) {
        return userService.getUser(index);
    }
}
