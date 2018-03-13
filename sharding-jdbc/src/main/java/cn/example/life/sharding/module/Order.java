package cn.example.life.sharding.module;

import cn.example.life.common.module.BaseModule;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Junhuiji on 2018/3/13 11:37.
 */
@Slf4j
@Entity
@Table(name = "t_order")
public class Order extends BaseModule {
    /**
     * 这里只有@ID 没有@GeneratedValue(strategy = GenerationType.AUTO) 是因为 分库分表的时候不能用         数据库主键自增，会产生重复的ID
     */
    @Id
    @Setter
    @Getter
    private Long orderId;
    @Setter
    @Getter
    private Long userId;
}
