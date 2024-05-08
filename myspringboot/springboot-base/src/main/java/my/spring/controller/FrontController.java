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

    //            3、新建工程，实现接口满足以下条件：
//    通过GET请求localhost:8083/getValue?key=XXX时，接口返回应用配置项中提前配置的各个key对应的值。
//    输入配置以外的key抛异常，配置项中有 key为A、B、C，对应的值为1、2、3。
//    接口增加校验，限制key只能传配置项中内容。


}
