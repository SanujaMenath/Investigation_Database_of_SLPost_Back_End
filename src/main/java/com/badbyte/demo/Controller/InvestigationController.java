package com.badbyte.demo.Controller;



import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.dto.InvestigationDTO;
import com.badbyte.demo.exceptions.responses.KeywordNotFoundResponse;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investigations")
@CrossOrigin(origins = "*")
public class InvestigationController {
    @Autowired
    private InvestigationService service;

    @GetMapping
    public List<Investigation> getAllInvestigations() {
        return service.getAllInvestigations();
    }


    @GetMapping("/{fileId}")
    public ResponseEntity<Object> getInvestigationByFileNumber(@PathVariable String fileId) {
        Investigation inv = service.getInvestigationByFileNumber(fileId);
        if (inv == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(inv);
    }

    @PostMapping
    public ResponseEntity<Object> createInvestigation( @RequestBody InvestigationDTO investigation) {
        try {
            return ResponseEntity.ok().body(service.saveInvestigation(investigation));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInvestigation(@PathVariable String id, @RequestBody InvestigationDTO updatedInvestigation) {

        return ResponseEntity.accepted().body(service.editInvestigation(id, updatedInvestigation));
    }
    

    @DeleteMapping("/{id}")
    public void deleteInvestigation(@PathVariable String id) {
        service.deleteInvestigation(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchInvestigations(@RequestParam String keyword) {
        try {
            if (keyword == null || keyword.isEmpty()) {
                KeywordNotFoundResponse response = new KeywordNotFoundResponse(this.getClass().getName(), "Keyword cannot be null or empty");
                return ResponseEntity.unprocessableEntity().body(response);
            }

            List<Investigation> results = service.searchInvestigations(keyword);
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

