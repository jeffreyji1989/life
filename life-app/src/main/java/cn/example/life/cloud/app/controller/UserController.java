package cn.example.life.cloud.app.controller;

import cn.example.life.api.user.UserService;
import cn.example.life.common.module.User;
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
    public List<User> showAllUser() {
        log.info("执行页面请求");
        List<User> users = userService.findAll();
        return users;
    }
}
