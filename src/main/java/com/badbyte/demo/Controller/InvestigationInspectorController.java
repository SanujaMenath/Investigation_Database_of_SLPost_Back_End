package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.InvestigationInspector;
import com.badbyte.demo.dto.InvInspectorDTO;
import com.badbyte.demo.services.InvInspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspectors")
public class InvestigationInspectorController {

        @Autowired
        private InvInspectorService inspectorService;

        @GetMapping
        public List<InvestigationInspector> getAllInspectors() {
            return inspectorService.getAllInspectors();
        }

        @GetMapping("/{nic}")
        public InvestigationInspector getInspectorById(@PathVariable String nic) {
            return inspectorService.getInspectorById(nic);
        }

        @PostMapping
        public InvestigationInspector createInspector(@RequestBody InvInspectorDTO inspector) {
            return inspectorService.saveInspector(inspector);
        }

        @PutMapping("/{nic}")
        public InvestigationInspector updateInspector(@PathVariable String nic, @RequestBody InvInspectorDTO inspector) {
            InvestigationInspector existingInspector = inspectorService.getInspectorById(nic);
            if (existingInspector != null) {
                inspector.setNic(nic);
                return inspectorService.saveInspector(inspector);
            }
            return null;
        }

        @DeleteMapping("/{nic}")
        public void deleteInspector(@PathVariable String nic) {
            inspectorService.deleteInspector(nic);
        }

}
