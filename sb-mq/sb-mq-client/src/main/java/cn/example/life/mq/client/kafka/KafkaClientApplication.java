package cn.example.life.mq.client.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 季先生 on 2018/3/21 11:30.
 */

@SpringBootApplication
@RestController
@Slf4j
public class KafkaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaClientApplication.class,args);
    }

    @KafkaListener(topics = "t1")
    public void receiveMsg(ConsumerRecord cr){
      log.info("topic:{},key:{},value:{}",cr.topic(),cr.key(),cr.value());
    }
}
