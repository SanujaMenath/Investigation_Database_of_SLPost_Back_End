package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.IIAssignment;
import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.Entity.InvestigationInspector;
import com.badbyte.demo.dto.IIAssignmentDTO;
import com.badbyte.demo.services.IIAssignmentService;
import com.badbyte.demo.services.InvInspectorService;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin
public class IIAssignmentController {

        @Autowired
        private IIAssignmentService assignmentService;

        @Autowired
        private InvestigationService investigationService;

        @Autowired
        private InvInspectorService investigationInspectorService;

        @GetMapping
        public List<IIAssignment> getAllAssignments() {
            return assignmentService.getAllAssignments();
        }

        @GetMapping("/{id}")
        public IIAssignment getAssignmentById(@PathVariable String CaseNo) {
            return assignmentService.getAssignmentById(CaseNo);
        }

    @PostMapping
    public ResponseEntity<Object> createAssignment(@RequestBody IIAssignmentDTO assignmentDTO) {
        // Fetch the Investigation and Inspector entities by their IDs
        Investigation investigation = investigationService.getInvestigationByFileNumber(assignmentDTO.getInvestigation().getFileId());
        InvestigationInspector inspector = investigationInspectorService.getInspectorById(assignmentDTO.getInspector().getNic());

        if (investigation == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (inspector == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        IIAssignment savedAssignment = assignmentService.saveAssignment(assignmentDTO);

        return ResponseEntity.ok(savedAssignment);
    }

    @PutMapping("/{id}")
    public IIAssignment updateAssignment(@PathVariable String caseNo, @RequestBody IIAssignmentDTO assignment) {
        IIAssignment existingAssignment = assignmentService.getAssignmentById(caseNo);
        if (existingAssignment != null) {
            assignment.setCaseNo(caseNo);
            return assignmentService.saveAssignment(assignment);
        }
        return null;
    }

        @DeleteMapping("/{id}")
        public void deleteAssignment(@PathVariable String CaseNo) {
            assignmentService.deleteAssignment(CaseNo);
        }

}
