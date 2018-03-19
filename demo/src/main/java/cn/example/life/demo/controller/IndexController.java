package cn.example.life.demo.controller;

import cn.example.life.demo.annotation.RequestLimit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;

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

    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@RequestBody A a) {
        log.info(a.toString());
//        log.info(b.toString());
        return environment.getProperty("aa") + environment.getProperty("bb");
    }

    @RequestLimit(count = 10, time = 5000)
    @RequestMapping("/urltest")
    @ResponseBody
    public String test(HttpServletRequest request, ModelMap modelMap) {
        return "aaa";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public void demo2(@Valid A demo, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                log.info(error.getDefaultMessage());
            }
        }

        B b = new B();
        b.setId(123L);
    }

}

@Slf4j
@ToString
@Setter
@Getter
class A {
    @NotBlank(message="用户名不能为空")
    private String userName;

    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;

    @AssertFalse(message = "必须为false")
    private Boolean isFalse;
}

@Slf4j
@ToString
@Setter
@Getter
class B {
    private long id;
    private String name;
}
