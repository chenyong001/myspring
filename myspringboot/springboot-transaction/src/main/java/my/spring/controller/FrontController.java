package my.spring.controller;

import my.spring.bean.User;
import my.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

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
    @GetMapping("updateUser")
    public int updateUser( User user) throws Exception {
        return userService.updateUser(user);
    }
    @GetMapping("updateUserByException")
    public int updateUserByException( User user) throws Exception {
        return userService.updateUserByException(user);
    }
    @GetMapping("updateUserByDealException")
    public int updateUserByDealException( User user)  {
        return userService.updateUserByDealException(user);
    }
    @GetMapping("updateUserByInner")
    public int updateUserByInner( User user)  {
        return userService.updateUserByInner(user);
    }
    @GetMapping("updateUserByThread")
    public int updateUserByThread( User user)  {
        return userService.updateUserByThread(user);
    }
    @GetMapping("updateUserByThread2")
    public int updateUserByThread2( User user) throws ExecutionException, InterruptedException {
        return userService.updateUserByThread2(user);
    }
    @GetMapping("updateUserByPropagate")
    public int updateUserByPropagate( User user)  {
        return userService.updateUserByPropagate(user);
    }

}
