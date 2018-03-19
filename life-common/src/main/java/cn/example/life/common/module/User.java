package cn.example.life.common.module;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by 季先生 on 2018/3/19 13:24.
 */

@Getter
@Setter
public class User extends BaseModule{
    private Long id;
    private String name;
    private int age;

    public User() {
    }

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
