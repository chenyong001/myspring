package my.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiaoShaController {


    /**
     * 秒杀
     */
    @GetMapping("/buy")
    public  void buy(){
//        1、从redis查库存，判断是否还有，如果没有则返回
//        2、如果有，则redis扣减库存，检查扣减后的库存如果小于0，则加回来，且返回抢失败了 --防止库存超卖
//        3、记录到消息发送表->发送mq消息，创建订单 -- 防止mq消息丢失
//        4、mq处理需注意冥等性  --乐观锁或redis分布式锁
//        5、高并发需要redis集群、mq集群
//        6、mq如果消息积压，可扩展消费者实例、线程池处理、判断消息时间超过1分钟则存入redis，否则存入mysql，有定时任务同步redis数据到mysql
//        7、如果redis集群崩溃，实现服务降级 --降级逻辑，数据存到rocksDB缓存，有定时任务去检查redis是否恢复，如果恢复则重做日志到redis
    }
}
