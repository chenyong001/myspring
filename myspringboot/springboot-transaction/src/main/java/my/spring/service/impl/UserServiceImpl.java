package my.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.spring.bean.User;
import my.spring.mapper.UserMapper;
import my.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:39
 * @Version: 1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
//    public static Map<String,User> userMap=new HashMap<String, User>();
//    static {
//        userMap.put("1",new User("张三",19));
//        userMap.put("2",new User("李4",44));
//    }

//    @Override
//    public User getUser(String index){
//        return userMap.get(index);
//    }

    @Autowired
    private UserServiceImpl userService;

    @Override
    public User getUser(String name){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        User user = this.baseMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public int updateUser(User user) {
        int result= this.baseMapper.updateById(user);
        return result;
    }


    /**
     * 事务失效的几种场景
     * 1、异常被捕获后没有抛出
     * 2、抛出非运行时异常
     * 3、方法内部直接调用 =============springboot无此问题，默认开启了事务,但关闭事务的主方法存在此问题
     * 4、新开启一个线程
     * 5、注解到private方法上  ==编译器检查，使用了@Transactional不能用非public
     * 6、数据库本身不支持
     * 7、事务传播属性设置错误
     */

    /**
     * 1、事务失效，异常被捕获未抛出,数据库操作未回滚
     * 解决方案：抛出运行时异常
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public int updateUserByDealException(User user) {
        int result= this.baseMapper.updateById(user);
        try {
            int a=1/0;
        } catch (Exception e) {
           e.printStackTrace();
//           throw  new RuntimeException("事务可以回滚");

        }
        return result;
    }
    /**
     * 2、事务失效，抛出非运行时异常，且未指定rollbackfor,数据库操作未回滚
     * 解决方案：指定非检查异常
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
//    @Transactional(rollbackFor = Exception.class)
    public int updateUserByException(User user) throws Exception {
        int result= this.baseMapper.updateById(user);
        try {
            int a=1/0;
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    /**
     * 3、事务失效，方法内部直接调用,数据库操作未回滚
     * 解决方案：注入自己，来调用
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED) //关闭事务
    public int updateUserByInner(User user) {
//        extracted(user);
        userService.extracted(user);
        return 1;
    }

    /**
     * 4、开启了一个线程 也不会回滚，因为spring实现事务的原理是通过ThreadLocal把数据库连接绑定到当前线程中，新开启一个线程获取到的连接就不是同一个了。
     * 解决方案：手动编程式控制子线程事务回滚，并返回结果到主线程让主线程也回滚
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updateUserByThread(User user) {
//        updateA(user);
        try {
//休眠1秒，保证updateStudentA先执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            updateA(user);
            int i = 1/0;
            updateA(user);
        }).start();
        return 1;
    }
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    @Transactional
    public int updateUserByThread2(User user) throws ExecutionException, InterruptedException {
        updateA(user);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
             /*
             手动开启事务
             */
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            // 事物隔离级别，开启新事务，这样会比较安全些。
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            // 获得事务状态
            TransactionStatus status = dataSourceTransactionManager.getTransaction(def);

            try {
                updateA(user);
                int i = 1/0;
                updateA(user);
                // 异常
                int a = 10 / 0;
                dataSourceTransactionManager.commit(status);
            } catch (Exception e) {
                log.error("有异常了！！！！！！！！");
                // 事务回滚
                dataSourceTransactionManager.rollback(status);
                throw new RuntimeException(e);
            }
            return "成功";
        }).exceptionally(e -> {
            log.error("返回异常了！！！！！，{}", e);
            return "500";
        });
        // 如果返回500则是出现异常，手动抛异常回滚主线程
        if (future.get().equals("500")) {
          throw new RuntimeException("500");
        }
        return 1;
    }




    /**
     * 5、事务传播属性设置错误 也不会回滚，注意传播属性的设置，比如设置了：PROPAGATION_NOT_SUPPORIED（以非事务的方式执行，如果当前有事务则把当前事务挂起）。
     * 解决方案：没法解决，不要使用
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int updateUserByPropagate(User user) {
        extracted(user);

        return 1;
    }





    @Transactional
    public void extracted(User user) {
        user.setAge(user.getAge()+10);
        int result= this.baseMapper.updateById(user);
        int a=1/0;
        user.setAge(user.getAge()+10);
         this.baseMapper.updateById(user);
    }

    public void updateA(User user) {
        user.setAge(user.getAge()+10);
        this.baseMapper.updateById(user);
    }




}
