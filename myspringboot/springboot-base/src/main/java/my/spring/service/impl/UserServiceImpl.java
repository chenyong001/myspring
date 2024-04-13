package my.spring.service.impl;

import my.spring.bean.User;
import my.spring.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:39
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    public static Map<String,User> userMap=new HashMap<String, User>();
    static {
        userMap.put("1",new User("张三",19));
        userMap.put("2",new User("李4",44));
    }

    @Override
    public User getUser(String index){
        return userMap.get(index);
    }

}
