package com.example.desiner.Controller;

import com.example.desiner.Model.RateOrder;
import com.example.desiner.Service.RateOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class RateOrderController {
private final RateOrderService rateOrderService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(rateOrderService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addRateOrder(@Valid @RequestBody RateOrder rateOrder){
        rateOrderService.addRateOrder(rateOrder);
        return ResponseEntity.status(200).body("rate added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateRateOrder(@PathVariable Integer id, @Valid @RequestBody RateOrder rateOrder){
        rateOrderService.updateRateOrder(id,rateOrder);
        return ResponseEntity.status(200).body("rate updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRateOrder(@PathVariable Integer id){
       rateOrderService.deleteRateOrder(id);
        return ResponseEntity.status(200).body("rate deleted");
    }




}
