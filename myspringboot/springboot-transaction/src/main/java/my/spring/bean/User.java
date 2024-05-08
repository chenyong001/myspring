package my.spring.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:36
 * @Version: 1.0
 **/
@Data
@TableName
public class User {
    @TableId
    private int id;
    public String name;
    public int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
