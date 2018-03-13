package cn.example.life.sharding.controller;

import cn.example.life.sharding.module.Order;
import cn.example.life.sharding.repository.OrderRepository;
import cn.example.life.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Junhuiji on 2018/3/13 14:16.
 */
@RestController
@RequestMapping()
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @RequestMapping("add")
    public Object add() {
//        for (int i = 0; i < 100; i++) {
//            Order order = new Order();
//            order.setUserId(new IdUtil(0, 0).nextId());
//            order.setOrderId(new IdUtil(0, 0).nextId());
//            orderRepository.save(order);
//        }
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        for (int i = 10; i < 20; i++) {
            Order order = new Order();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        return "success";
    }

    @RequestMapping("query")
    public Object queryAll() {
        return orderRepository.findAll();
    }

    @RequestMapping("page")
    public Object queryPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Order order = new Order();
        order.setOrderId(5L);
        return orderService.findPageByCondition(order, page, size);
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long orderId) {
        orderRepository.delete(orderId);
        return "success";
    }

    @RequestMapping("get/{id}")
    public String getOne(@PathVariable("id") Long orderId) {
        Order one = orderRepository.findOne(orderId);
        if (null == one){
           return "貌似已经被删除了";
        }
        return one.toString();
    }

}
