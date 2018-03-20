package cn.example.life.api.user;

import cn.example.life.common.module.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/19 13:42.
 */
@FeignClient(value = "${user.service.name}")
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/user/find/all",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    List<User> findAll();

    @RequestMapping(value = "/user/find/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    User findOneUser(@PathVariable("id") Long id);
}
