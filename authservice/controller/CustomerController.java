package gbs.project.authservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import gbs.project.authservice.dto.LoginDto;
import gbs.project.authservice.model.Customer;
import gbs.project.authservice.repository.CustomerRepository;
import gbs.project.authservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customerData")
@Slf4j

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;


   
    @GetMapping("/login")
    public HashMap<Object, Object> getUserByLogin(@RequestBody LoginDto loginDto) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(loginDto, Customer.class);

        var response = new HashMap<Object, Object>();
        List<Customer> listCustomer = null;
        try {
            if(customer.getUserName() != null && customer.getPassword() != null) {
                // listCustomer = new ArrayList<>();
                listCustomer = customerRepository.getUserByLogin(customer.getUserName(), customer.getPassword());

                if(listCustomer.size() >= 1 && listCustomer != null) {
                    response.put("message", "customer login successfully");
                }else {
                    response.put("message", "customer login failed");
                }
            }            
        } catch (Exception e) {
          
           log.error("Customer login exception awaiting termination",e);
     }
        return response;
    }

    @GetMapping("/customers")
    public ResponseEntity<Map<Object, Object>> getAll() {
        var Regist = customerRepository.findAll();
        var response = new HashMap<Object, Object>();

        if (Regist.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "customer found");
        response.put("customers", Regist);
        response.put("status", HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    //@GetMapping("")
   // public ResponseEntity<List<Customer>> getItems() {
   //     return ResponseEntity.ok().body(customerService.findAll());
    //}

    @PostMapping({ "/" , "" })
    public ResponseEntity<Map<Object , Object>> createItems(@RequestBody Customer customer) {
        Map<Object , Object> response = new HashMap<>();
        var it = customerService.create(customer);
        response.put("status" , HttpStatus.CREATED);
        response.put("register" , customerService.create(customer));
        response.put("location" , "/api/customer_data/" + it.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}


