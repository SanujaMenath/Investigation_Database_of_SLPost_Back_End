package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.Suspector;
import com.badbyte.demo.dto.SuspectorDTO;
import com.badbyte.demo.exceptions.responses.KeywordNotFoundResponse;
import com.badbyte.demo.services.SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/suspector")
@CrossOrigin(origins = "*")
public class SuspectController {

    @Autowired
    private SuspectorService service;

    @PostMapping
    public ResponseEntity<Suspector> createSuspector(@RequestBody SuspectorDTO suspectorDTO) {
        try {
            Suspector sus = service.saveSuspector(suspectorDTO);
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
    public List<Suspector> getAllSuspectors() {
        System.out.println(LocalDateTime.now().toString());
        return service.getAllSuspectors();
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchSuspector(@RequestParam String keyword) {
        try {
            if (keyword == null || keyword.isEmpty()) {
                KeywordNotFoundResponse response = new KeywordNotFoundResponse(this.getClass().getName(), "Keyword cannot be null or empty");
                return ResponseEntity.unprocessableEntity().body(response);
            }

            List<Suspector> results = service.searchSuspectors(keyword);
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
