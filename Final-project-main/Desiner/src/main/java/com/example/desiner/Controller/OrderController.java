package com.example.desiner.Controller;

import com.example.desiner.Model.Order;
import com.example.desiner.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(orderService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addOrder(@Valid @RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(200).body("order added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @Valid @RequestBody Order order){
        orderService.updateOrder(id,order);
        return ResponseEntity.status(200).body("order updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body("order deleted");
    }


}
