package cn.example.life.cloud.app.controller;

import cn.example.life.common.module.User;
import cn.example.life.service.api.user.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/19 14:12.
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "showAllUser", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "showAllUserError")
    public List<User> showAllUser() {
//        System.out.println(100/0);
        log.info("执行页面请求");
        List<User> users = userService.findAll();
        return users;
    }

    public List<User> showAllUserError(){
        log.info("=======================");
        return null;
    }
}
