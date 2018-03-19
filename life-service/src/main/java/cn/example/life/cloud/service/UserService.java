package cn.example.life.cloud.service;

import cn.example.life.common.module.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/19 13:42.
 */
@FeignClient(value = "life-service")
public interface UserService {
    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/user/users",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE )
    List<User> queryAll();
}
