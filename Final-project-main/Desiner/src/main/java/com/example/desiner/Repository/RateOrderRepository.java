package com.example.desiner.Repository;

import com.example.desiner.Model.RateOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateOrderRepository extends JpaRepository<RateOrder,Integer> {

    RateOrder findRateOrderById(Integer id);
}
