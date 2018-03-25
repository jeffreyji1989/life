package cn.example.life.service.user.impl;

import cn.example.life.common.module.User;
import cn.example.life.core.utils.IdUtil;
import cn.example.life.service.api.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by 季先生 on 2018/3/19 13:49.
 */
@Service("userServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService {

    private ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
    @Autowired
    private IdUtil idUtil;

    @Override
    public User add(User user) {
        log.info("执行到add方法，user:{}", user);
        Long id = idUtil.nextId();
        if (null == user) {
            user = new User(id, "随机的名字" + id, 20);
        }
        user.setId(id);
        userMap.put(user.getId(), user);
        log.info("add方法执行完毕！return的结果是:{}", user);
        return user;
    }

    @Override
    public User update(User user) {
        log.info("执行update方法，传递的user对象:{}", user);
        User oldUser = userMap.get(user.getId());
        log.info("更新前的对象信息是:{}", oldUser);
        userMap.remove(user.getId());
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(long id) {
        log.info("execute delete methode,param id:{}", id);
        log.info("before delete size :{}", userMap.size());
        userMap.remove(id);
        log.info("after delte size :{}", userMap.size());
    }

    @Override
    public User findOne(Long id) {
        log.info("获取到的值ID：{}", id);
        User user = new User(id, "哼哼哈嘿", 18);
        log.info("返回的值:{}", user);
        return user;
    }

    @Override
    public List<User> findAll() {
       System.out.println(100/0);
        log.info("开始执行用户服务...");
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            result.add(new User(idUtil.nextId(), "name" + i, 100 - i));
        }
        log.info("总共查询出用户:{}个,其中第一个的信息是:{}", result.size(), result.get(0));
        return result;
    }
}
