package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.Model.RateOrder;
import com.example.desiner.Repository.RateOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateOrderService {

    private final RateOrderRepository rateOrderRepository;

    public List<RateOrder> getAll(){
        return rateOrderRepository.findAll();
    }
    public void addRateOrder(RateOrder rateOrder){
        rateOrderRepository.save(rateOrder);
    }
    public void updateRateOrder(Integer id, RateOrder rateOrder){
        RateOrder r = rateOrderRepository.findRateOrderById(id);
        if (r == null)
            throw new ApiException("Not found");
        r.setOrder(rateOrder.getOrder());
         r.setRating(rateOrder.getRating());
        rateOrderRepository.save(r);
    }
    public void deleteRateOrder(Integer id){
        RateOrder r = rateOrderRepository.findRateOrderById(id);
        if (r == null)
            throw new ApiException("Not found");
        rateOrderRepository.delete(r);
    }



}
