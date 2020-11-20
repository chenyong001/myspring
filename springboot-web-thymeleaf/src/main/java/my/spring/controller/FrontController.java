package my.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:33
 * @Version: 1.0
 **/
@Controller
public class FrontController {
    @GetMapping
    public String index(){
        return "index";
    }
}
