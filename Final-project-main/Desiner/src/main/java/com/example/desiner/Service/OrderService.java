package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.Order;
import com.example.desiner.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
private final OrderRepository orderRepository;


    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    public void addOrder(Order order){

        orderRepository.save(order);
    }
    public void updateOrder(Integer id,Order order){
        Order oldorder=orderRepository.findOrderById(id);
        if(oldorder==null){
            throw new ApiException("order not found");
        }
oldorder.setCustomer(order.getCustomer());
        oldorder.setDesigner(order.getDesigner());
        oldorder.setDescription(order.getDescription());
        oldorder.setTotalPrice(order.getTotalPrice());
        orderRepository.save(oldorder);
    }
    public void deleteOrder(Integer id){
        Order order=orderRepository.findOrderById(id);

        if(order==null){
            throw new ApiException("order not found");
        }

        orderRepository.delete(order);
    }


}
