package my.spring.bean;

import lombok.Data;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:36
 * @Version: 1.0
 **/
@Data
public class User {
    public String name;
    public int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
