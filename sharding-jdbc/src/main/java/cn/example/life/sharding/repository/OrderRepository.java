package cn.example.life.sharding.repository;

import cn.example.life.sharding.module.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/13 15:25.
 *  PagingAndSortingRepository 可分页
 *  JpaSpecificationExecutor 可分页 可按条件查询
 *  
 */

public interface OrderRepository extends PagingAndSortingRepository<Order,Long>,JpaSpecificationExecutor<Order> {
}
