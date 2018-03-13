package cn.example.life.demo.controller;

import cn.example.life.demo.annotation.RequestLimit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Junhuiji on 2018/2/8 16:13.
 */
@Controller
@RequestMapping
@Slf4j
public class IndexController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String hello() {
        return environment.getProperty("aa") + environment.getProperty("bb");
    }

    @PostMapping(value = "/hello",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@RequestBody A a ) {
        log.info(a.toString());
//        log.info(b.toString());
        return environment.getProperty("aa") + environment.getProperty("bb");
    }

    @RequestLimit(count=10,time=5000)
    @RequestMapping("/urltest")
    @ResponseBody
    public String test(HttpServletRequest request, ModelMap modelMap) {
        return "aaa";
    }


}

@Slf4j
@ToString
class A {
    @Setter
    @Getter
    private long id;
    @Setter
    @Getter
    private String name;
}

@Slf4j
@ToString
class B {
    @Setter
    @Getter
    private long id;
    @Setter
    @Getter
    private String name;
}
