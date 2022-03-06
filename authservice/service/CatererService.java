package gbs.project.authservice.service;

import java.util.List;
import java.util.Optional;

import gbs.project.authservice.model.Caterer;

public interface CatererService {
    
    Caterer create(Caterer caterer);

    Optional<Caterer> findById(Integer id);

    List<Caterer> findAll();

    List<Caterer> findAllById(List<Integer> ids);

    void delete(Integer id);

}
