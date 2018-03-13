package cn.example.life.sharding;

import cn.example.life.core.utils.IdUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Junhuiji on 2018/3/13 14:29.
 */
@SpringBootApplication
public class ShardIngApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardIngApplication.class,args);
    }

    @Bean
    public IdUtil idUtil(){
        return  new IdUtil();
    }
}
