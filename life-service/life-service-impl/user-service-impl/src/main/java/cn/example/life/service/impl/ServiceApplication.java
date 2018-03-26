package cn.example.life.service.impl;

import cn.example.life.core.utils.IdUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by 季先生 on 2018/3/19 13:56.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Bean
    public IdUtil idUtils() {
        return new IdUtil(0, 0);
    }
}
