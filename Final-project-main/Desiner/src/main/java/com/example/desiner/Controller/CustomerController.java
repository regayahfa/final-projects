package com.example.desiner.Controller;

import com.example.desiner.DTO.CustomerDTO;
import com.example.desiner.Model.Customer;

import com.example.desiner.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
 private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getAll(){
        List<Customer> customers=customerService.findAll();
        return ResponseEntity.status(200).body(customers);
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return ResponseEntity.status(200).body("Added Done");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer,@PathVariable Integer id){
        customerService.updateCustomer(customer, id);
        return ResponseEntity.status(200).body("Updated Done");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Deleted Done");
    }


}
