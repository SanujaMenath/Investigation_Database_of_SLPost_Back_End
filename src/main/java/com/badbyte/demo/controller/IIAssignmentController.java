package com.badbyte.demo.controller;

import com.badbyte.demo.entity.Investigation_Investigation_Inspectors;
import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.entity.Investigation_Inspectors;
import com.badbyte.demo.dto.Investigation_Investigation_InspectorsDTO;
import com.badbyte.demo.services.IIAssignmentService;
import com.badbyte.demo.services.InvInspectorService;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:8080")
public class IIAssignmentController {

        @Autowired
        private IIAssignmentService assignmentService;

        @Autowired
        private InvestigationService investigationService;

        @Autowired
        private InvInspectorService investigationInspectorService;

        @GetMapping
        public List<Investigation_Investigation_Inspectors> getAllAssignments() {
            return assignmentService.getAllAssignments();
        }

        @GetMapping("/{id}")
        public Investigation_Investigation_Inspectors getAssignmentById(@PathVariable String CaseNo) {
            return assignmentService.getAssignmentById(CaseNo);
        }

    @PostMapping
    public ResponseEntity<Object> createAssignment(@RequestBody Investigation_Investigation_InspectorsDTO assignmentDTO) {
        // Fetch the Investigation and Inspector entities by their IDs
        Investigations investigations = investigationService.getInvestigationById(assignmentDTO.getInvestigation().getId());
        Investigation_Inspectors inspector = investigationInspectorService.getInspectorById(assignmentDTO.getInspector().getNic());

        if (investigations == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (inspector == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        Investigation_Investigation_Inspectors savedAssignment = assignmentService.saveAssignment(assignmentDTO);

        return ResponseEntity.ok(savedAssignment);
    }

    @PutMapping("/{id}")
    public Investigation_Investigation_Inspectors updateAssignment(@PathVariable String caseNo, @RequestBody Investigation_Investigation_InspectorsDTO assignment) {
        Investigation_Investigation_Inspectors existingAssignment = assignmentService.getAssignmentById(caseNo);
        if (existingAssignment != null) {
            assignment.setCaseNo(caseNo);
            return assignmentService.saveAssignment(assignment);
        }
        return null;
    }

        @DeleteMapping("/{id}")
        public void deleteAssignment(@PathVariable String FileId) {
            assignmentService.deleteAssignment(FileId);
        }

}
