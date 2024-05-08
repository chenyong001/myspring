package my.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author: chenyong
 * @Date: 2020/11/20 14:28
 * @Version: 1.0
 **/
@SpringBootApplication
@MapperScan("my.spring.mapper")
public class SpringbootTransactionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionApplication.class,args);
    }
}
