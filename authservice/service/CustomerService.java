package gbs.project.authservice.service;

import java.util.List;
import java.util.Optional;

import gbs.project.authservice.model.Customer;

public interface CustomerService {

    Customer create(Customer customer);

    Optional<Customer> findById(Integer id);

    List<Customer> findAll();

    List<Customer> findAllById(List<Integer> ids);

    void delete(Integer id);

    
}
