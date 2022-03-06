package gbs.project.authservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gbs.project.authservice.model.Caterer;
import gbs.project.authservice.repository.CatererRepository;

@Service

public class CatererServiceImpl implements CatererService{

    @Autowired
    private CatererRepository catererRepository;

    @Override
    public Caterer create(Caterer caterer) {
        
        return catererRepository.save(caterer);
    }

    @Override
    public Optional<Caterer> findById(Integer id) {
        
        return catererRepository.findById(id);
    }

    @Override
    public List<Caterer> findAll() {
        
        return catererRepository.findAll();
    }

   @Override
    public List<Caterer> findAllById(List<Integer> ids) {
        
        return catererRepository.findAllById(ids);
    }

    @Override
    public void delete(Integer id) {
        catererRepository.deleteById(id);
        
    }
    
}
