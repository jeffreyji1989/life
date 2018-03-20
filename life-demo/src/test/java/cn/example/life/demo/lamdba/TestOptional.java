package cn.example.life.demo.lamdba;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

/**
 * Created by Junhuiji on 2018/2/6 13:22.
 */
@Slf4j
public class TestOptional {
    @Test
    public void test() {
        // 1 存在即返回否则返回默认值
        String s1 = "abc";
        String result = Optional.of(s1).orElse("不存在返回false!");
        log.info("result:{}", result);
        s1 = null;
        result = Optional.ofNullable(s1).orElse("不存在返回false!");
        log.info("result:{}", result);

        // 2 存在即返回，否则you由函数返回
        User u = null;
        Optional<User> userOptional = Optional.ofNullable(u);
        User userResult = userOptional.orElseGet(() -> new User().createNewUser());
        log.info("有默认值的user:{}",userResult);
        userOptional = Optional.ofNullable(new User(1L,"JEFFREY"));
        userResult = userOptional.orElseGet(() -> new User().createNewUser());
        log.info("有值的user:{}",userResult);
        


    }

    
}

@ToString
@EqualsAndHashCode
class User{

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User createNewUser(){
        User u = new User();
        u.setId(0L);
        u.setName("defalut name");
        return u;
    }

}