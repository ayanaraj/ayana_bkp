package gbs.project.authservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gbs.project.authservice.dto.LoginDto;
import gbs.project.authservice.model.Caterer;
import gbs.project.authservice.repository.CatererRepository;
import gbs.project.authservice.service.CatererService;

@RestController
@RequestMapping("caterer_data")
public class CatererController {

    @Autowired
    private CatererService catererService;

    @Autowired
    private CatererRepository catererRepository;

    @GetMapping("/signin")
    public HashMap<Object, Object> getUserByLogin(@RequestBody LoginDto loginDto) {
        var response = new HashMap<Object, Object>();

        ModelMapper modelMapper = new ModelMapper();
        Caterer caterer = modelMapper.map(loginDto, Caterer.class);

        
        List<Caterer> listCaterer = null;
        try {
            if(caterer.getCatererUsername() != null && caterer.getCatererPassword() != null) {
                 
                // listCaterer = new ArrayList<>();
                listCaterer = catererRepository.getUserByLogin(caterer.getCatererUsername(), caterer.getCatererPassword());

                if(listCaterer.size() >= 1 &&  listCaterer!= null) {
                    response.put("message", "caterer login successfully");
                }else {
                    response.put("message", "caterer login failed");
                }
            }            
        } catch (Exception e) {
            
     }
        return response;
    }

   @GetMapping("/caterers")
    public ResponseEntity<Map<Object, Object>> getAll() {
       var Regist = catererRepository.findAll();
        var response = new HashMap<Object, Object>();

       if (Regist.isEmpty()) {
           response.put("message", "No caterers found");
           response.put("status", HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "caterer found");
        response.put("caterers", Regist);
        response.put("status", HttpStatus.OK);

       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping({ "/" , "" })
    public ResponseEntity<Map<Object , Object>> createItems(@RequestBody Caterer caterer) {
        Map<Object , Object> response = new HashMap<>();
        var it = catererService.create(caterer);
        response.put("status" , HttpStatus.CREATED);
        response.put("register" , catererService.create(caterer));
        response.put("location" , "/api/cateres_data/" + it.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}