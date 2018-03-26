package cn.example.life.service.impl.book;

import cn.example.life.core.utils.IdUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by 季先生 on 2018/3/26 13:54.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BookServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class,args);
    }

    @Bean
    public IdUtil idUtils() {
        return new IdUtil(0, 0);
    }
}
