package cn.example.life.sharding.service.impl;

import cn.example.life.sharding.module.Order;
import cn.example.life.sharding.repository.OrderRepository;
import cn.example.life.sharding.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 季先生 on 2018/3/13 16:25.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Page<Order> findPageByCondition(final Order queryOrder,Integer page,Integer size) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "orderId");
        Page<Order> orderPage = orderRepository.findAll(new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (null != queryOrder.getOrderId()) {
                    list.add(cb.greaterThan(root.get("orderId"), queryOrder.getOrderId()));
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
        return orderPage;
    }
}
