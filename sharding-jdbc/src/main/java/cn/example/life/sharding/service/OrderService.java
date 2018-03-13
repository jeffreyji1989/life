package cn.example.life.sharding.service;

import cn.example.life.sharding.module.Order;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/13 16:25.
 */
public interface OrderService {
    Page<Order> findPageByCondition(Order order,Integer page,Integer size);
}
