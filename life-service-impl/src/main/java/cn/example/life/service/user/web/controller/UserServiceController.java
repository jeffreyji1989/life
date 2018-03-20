package cn.example.life.service.user.web.controller;

import cn.example.life.api.user.UserService;
import cn.example.life.common.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/20 14:20.
 */
@RestController
public class UserServiceController implements UserService {

    @Autowired
    @Qualifier("userServiceImpl")// 这两个注解必须都写才有效，不写@Autowired的值位null
    private UserService userService;

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User findOneUser(Long id) {
        return userService.findOneUser(id);
    }
}
