package com.badbyte.demo.Controller;



import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.dto.InvestigationDTO;
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
    public Investigation createInvestigation(@RequestBody InvestigationDTO investigation) {
        return service.saveInvestigation(investigation);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInvestigation(@PathVariable Long id, @RequestBody InvestigationDTO updatedInvestigation) {

        return ResponseEntity.accepted().body(service.editInvestigation(id, updatedInvestigation));
    }
    

    @DeleteMapping("/{id}")
    public void deleteInvestigation(@PathVariable Long id) {
        service.deleteInvestigation(id);
    }
}

