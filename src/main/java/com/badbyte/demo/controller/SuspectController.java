package com.badbyte.demo.controller;

import com.badbyte.demo.entity.Suspectors;
import com.badbyte.demo.dto.SuspectorDTO;
import com.badbyte.demo.services.SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/suspector")
@CrossOrigin(origins = "http://localhost:8080")
public class SuspectController {

    @Autowired
    private SuspectorService service;

    @PostMapping
    public ResponseEntity<Suspectors> createSuspector(@RequestBody SuspectorDTO suspectorDTO) {
        try {
            Suspectors sus = service.saveSuspector(suspectorDTO);
            if(sus!=null){
                return ResponseEntity.ok().body(sus);
            }

            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping
    public List<Suspectors> getAllSuspectors() {
        System.out.println(LocalDateTime.now().toString());
        return service.getAllSuspectors();
    }

}
