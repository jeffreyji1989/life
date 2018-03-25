package cn.example.life.service.user.controller;

import cn.example.life.common.module.User;
import cn.example.life.service.aop.limit.RequestLimit;
import cn.example.life.service.api.user.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/20 14:20.
 */
@RestController
public class UserResource implements UserService {

    @Autowired
    @Qualifier("userServiceImpl")// 这两个注解必须都写才有效，不写@Autowired的值为null
    private UserService userService;

    @Override
    @ApiOperation(value = "添加用户信息")
    @ApiImplicitParam(name = "name", value = "用户详细实体user", required = true, dataType = "User")
    public User add(User user) {
        return userService.add(user);
    }

    @Override
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public User update(User user) {
        return userService.update(user);
    }

    @Override
    @ApiOperation(value = "删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID值", required = true, dataType = "Long")
    public void delete(long id) {
        userService.delete(id);
    }

    @Override
    @ApiOperation(value = "查找某个用户")
    @ApiImplicitParam(name = "id", value = "用户ID值", required = true, dataType = "Long")
    public User findOne(Long id) {
        return userService.findOne(id);
    }

    @Override
    @ApiOperation(value = "查询全部用户")
    @RequestLimit(count = 10L)
    public List<User> findAll() {
        return userService.findAll();
    }

}
