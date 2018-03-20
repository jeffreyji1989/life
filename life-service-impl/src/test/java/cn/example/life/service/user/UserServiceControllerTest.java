//package cn.example.life.service.user;
//
//import cn.example.life.common.module.User;
//import cn.example.life.service.user.web.controller.UserServiceController;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
///**
// * Created by 季先生 on 2018/3/20 16:38.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebMvcTest(UserServiceController.class)
//@Slf4j
//public class UserServiceControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private UserServiceController userServiceController;
//
//    @Test
//    public void testCrud(){
//        User user = new User();
//        user.setName("test");
//        user.setAge(18);
//        User beforeAddUser = userServiceController.add(user);
//        log.info(beforeAddUser.toString());
//    }
//
//}
