package com.test.controller;

import com.test.db.DB;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
//@Validated
public class TestController  {
    //            3、新建工程，实现接口满足以下条件：
//    通过GET请求localhost:8083/getValue?key=XXX时，接口返回应用配置项中提前配置的各个key对应的值。
//    输入配置以外的key抛异常，配置项中有 key为A、B、C，对应的值为1、2、3。
//    接口增加校验，限制key只能传配置项中内容。


    @GetMapping("getValue")
//    @Validated
    public Integer getValue(@Valid @Pattern(regexp="^(A|B|C)$", message = "只能是A或B或C")
                                    String key) {
        Integer value;
        if( DB.concurrentHashMap.containsKey(key)){
//            配置项中有 key为A、B、C，对应的值为1、2、3。
            value = DB.concurrentHashMap.get(key);
        }else {
//            输入配置以外的key抛异常
            throw  new RuntimeException("key 未配置");
        }
        return value;
    }

}
