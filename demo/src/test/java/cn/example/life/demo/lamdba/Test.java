package cn.example.life.demo.lamdba;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Junhuiji on 2018/2/8 17:16.
 */
@Slf4j
public class Test {
    @org.junit.Test
    public void test1(){
        String regex = "^(1)\\d{10}$";
        boolean flag = "123123123".matches(regex);
        log.info(flag + "");
        flag = "1 2345678901".matches(regex);
        log.info(flag + "");
    }

    @org.junit.Test
    public void test2(){
        String regex = "^(1)\\d{10}$";
        Set<String> set = new HashSet<>();
//        set.add(null);
        set.add("12345678998");
        set.add("12345578998");
//        set.add("1234567867598");
//        set.add("1234567 8998");
//        set.add("1234567");
//        set.add("12345672584");
//        set.add("123456725汉子");
//        set.add("");

        Predicate<String> filterCondition = phone -> null == phone || StringUtils.isEmpty(phone) || !phone.matches(regex);

        //简单校验手机号是否是符合条件
        List<String> errorCollection = set.stream().filter(mobile -> filterCondition.test(mobile)).collect(Collectors.toList());
        if (null == errorCollection || errorCollection.size() == 0) {
            log.info("发送成功");
        } else {
            log.error("本次批量发送消息失败，原因是以下手机号有误：{}", errorCollection);
        }
    }
}
