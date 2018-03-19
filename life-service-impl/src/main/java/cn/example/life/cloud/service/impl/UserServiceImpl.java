package cn.example.life.cloud.service.impl;

import cn.example.life.cloud.service.UserService;
import cn.example.life.common.module.User;
import cn.example.life.core.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 季先生 on 2018/3/19 13:49.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private IdUtil idUtil;

    @Override
    public List<User> queryAll() {
        log.info("开始执行用户服务...");
        List<User> result = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            result.add(new User(idUtil.nextId(), "name" + i, 100 - i));
        }
        log.info("总共查询出用户:{}个,其中第一个的信息是:{}",result.get(0));
        return result;
    }
}
