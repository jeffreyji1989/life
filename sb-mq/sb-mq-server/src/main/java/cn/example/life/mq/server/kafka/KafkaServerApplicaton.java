package cn.example.life.mq.server.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 季先生 on 2018/3/21 11:29.
 */
@SpringBootApplication
@RestController
@Slf4j
public class KafkaServerApplicaton {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaServerApplicaton.class,args);
    }

    @RequestMapping("/send")
    @ResponseBody
    String send(String topic, String key, String data) {
        ListenableFuture result = kafkaTemplate.send(topic, key, data);
        log.info("返回的结果:{}",result.isDone() + "");
        return "success";
    }
}
