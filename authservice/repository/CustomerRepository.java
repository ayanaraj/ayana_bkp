package gbs.project.authservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gbs.project.authservice.model.Customer;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("FROM Customer p WHERE p.userName = ?1 and p.password = ?2")
    List<Customer> getUserByLogin(String userName, String password);
    
}
