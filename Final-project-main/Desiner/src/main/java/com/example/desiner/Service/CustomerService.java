package com.example.desiner.Service;

import com.example.desiner.ApiException.ApiException;
import com.example.desiner.DTO.CustomerDTO;
import com.example.desiner.Model.Customer;
import com.example.desiner.Model.MyUser;
import com.example.desiner.Repository.CustomerRepository;
import com.example.desiner.Repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MyUserRepository myUserRepository;
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerDTO dto){
        MyUser myUser =myUserRepository.findMyUserById(dto.getUser_id());

        if (myUser==null){
            throw new ApiException("Can't add Customer, Not found");
        }
        Customer customer=new Customer(null, dto.getName(), dto.getEmail(), dto.getLocation(),myUser,null);

    }

    public void updateCustomer(Customer customer,Integer id){
        Customer c1=customerRepository.findCustomerById(id);
        if (c1==null){
            throw new ApiException("Not Found");
        }
        c1.setId(c1.getId());
        c1.setName(c1.getName());
        c1.setEmail(customer.getEmail());
        c1.setLocation(customer.getLocation());
        customerRepository.save(c1);
    }

    public void deleteCustomer(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if (customer==null) {
            throw new ApiException("Not Found");
        }
        customerRepository.delete(customer);
}
}
