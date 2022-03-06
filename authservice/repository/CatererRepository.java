package gbs.project.authservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gbs.project.authservice.model.Caterer;
@Repository

public interface CatererRepository extends JpaRepository<Caterer,Integer>{
    
    @Query("FROM Caterer c WHERE c.catererUsername = ?1 and c.catererPassword = ?2")
    List<Caterer> getUserByLogin(String catererUsername, String catererPassword);
    
}
