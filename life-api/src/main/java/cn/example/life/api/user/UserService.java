package cn.example.life.api.user;

import cn.example.life.common.module.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务接口
 */
@FeignClient(value = "${user.service.name}", fallback = UserServiceHystric.class)
public interface UserService {

    @PostMapping(value = "/user/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User add(@RequestBody User user);

    @PostMapping(value = "/user/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    User update(@RequestBody User user);

    @DeleteMapping(value = "/user/delete/{id}")
    void delete(@PathVariable("id") long id);

    @GetMapping(value = "/user/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    User findOne(@PathVariable("id") Long id);

    /**
     * 查询所有用户
     *
     * @return
     */
    @RequestMapping(value = "/user/find/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> findAll();


}

@Slf4j
@Component
class UserServiceHystric implements UserService {

    @Override
    public User add(User user) {
        log.info("用户参数user:{}", user);
        return user;
    }

    @Override
    public User update(User user) {
        log.info("用户参数user:{}", user);
        return null;
    }

    @Override
    public void delete(long id) {
        log.info("用户参数id:{}", id);

    }

    @Override
    public User findOne(Long id) {
        log.info("用户参数id:{}", id);
        return null;
    }

    @Override
    public List<User> findAll() {
        log.info("查询所有用户出错！");
        return null;
    }
}
