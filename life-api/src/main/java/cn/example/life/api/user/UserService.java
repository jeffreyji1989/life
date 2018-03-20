package cn.example.life.api.user;

import cn.example.life.common.module.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户服务接口
 */
@FeignClient(value = "${user.service.name}")
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
