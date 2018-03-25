package cn.example.life.cloud.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by 季先生 on 2018/3/19 14:10.
         */
@SpringBootApplication
//用feign的时候，只需要在调用曾 加上该注解，并且指定服务接口提供的包
@EnableFeignClients(basePackages = {"cn.example.life.service.api"})

@EnableCircuitBreaker
public class AppApplicaation {
    public static void main(String[] args) {
        SpringApplication.run(AppApplicaation.class,args);
    }
}
