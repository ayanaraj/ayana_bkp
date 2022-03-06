package gbs.project.authservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gbs.project.authservice.model.Customer;
import gbs.project.authservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
   public Customer create(Customer customer) {
        
       return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllById(List<Integer> ids) {
        
        return customerRepository.findAllById(ids);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
        
    }
    
}
