package cn.example.life.sharding.repository;

import cn.example.life.sharding.module.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 季先生 on 2018/3/13 15:25.
 */
public interface OrderRepository extends CrudRepository<Order,Long>,JpaSpecificationExecutor<Order> {
}
