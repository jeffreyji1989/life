package cn.example.life.service.api.user.hystrix;//package cn.example.life.api.user.hystrix;
//
//import cn.example.life.api.user.UserService;
//import cn.example.life.common.module.User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * Created by 季先生 on 2018/3/23 15:27.
// */
//@Component
//@Slf4j
//public class UserServiceHystric implements UserService {
//
//    @Override
//    public User add(User user) {
//        log.info("用户参数user:{}", user);
//        return user;
//    }
//
//    @Override
//    public User update(User user) {
//        log.info("用户参数user:{}", user);
//        return null;
//    }
//
//    @Override
//    public void delete(long id) {
//        log.info("用户参数id:{}", id);
//
//    }
//
//    @Override
//    public User findOne(Long id) {
//        log.info("用户参数id:{}", id);
//        return null;
//    }
//
//    @Override
//    public List<User> findAll() {
//        log.info("查询所有用户出错！");
//        return null;
//    }
//
//
//}
