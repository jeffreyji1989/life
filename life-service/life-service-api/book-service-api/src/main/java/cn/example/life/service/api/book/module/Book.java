package cn.example.life.service.api.book.module;

import cn.example.life.common.module.BaseModule;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 季先生 on 2018/3/26 13:49.
 */
@Getter
@Setter
@ToString
public class Book extends BaseModule {
    private long id;
    private String name;
    private double price;
}
