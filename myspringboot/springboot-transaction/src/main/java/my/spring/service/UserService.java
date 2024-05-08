package my.spring.service;

import my.spring.bean.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

/**
 * @Description
 * @Author: 50212
 * @Date: 2020/11/20 14:39
 * @Version: 1.0
 **/
public interface UserService   {
    User getUser(String index);


    int updateUser(User user);

    @Transactional
    int updateUserByDealException(User user);

    @Transactional
    int updateUserByException(User user) throws Exception;

    @Transactional
    int updateUserByInner(User user);

    int updateUserByThread(User user);

    int updateUserByThread2(User user) throws ExecutionException, InterruptedException;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    int updateUserByPropagate(User user);
}
