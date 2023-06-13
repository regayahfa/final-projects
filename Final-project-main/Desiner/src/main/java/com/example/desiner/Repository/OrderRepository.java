package com.example.desiner.Repository;

import com.example.desiner.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findOrderById(Integer id);
}
