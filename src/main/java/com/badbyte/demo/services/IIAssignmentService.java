package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Investigation_Investigation_Inspectors;
import com.badbyte.demo.dto.Investigation_Investigation_InspectorsDTO;
import com.badbyte.demo.repository.IIAssignmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIAssignmentService {

        @Autowired
        ModelMapper modelMapper;

        @Autowired
        private IIAssignmentRepo assignmentRepository;

        public List<Investigation_Investigation_Inspectors> getAllAssignments() {
            return assignmentRepository.findAll();
        }

        public Investigation_Investigation_Inspectors getAssignmentById(String caseNo) {
            return assignmentRepository.findById(caseNo).orElse(null);
        }

        public Investigation_Investigation_Inspectors saveAssignment(Investigation_Investigation_InspectorsDTO assignment) {
            Investigation_Investigation_Inspectors mappedAssignment = modelMapper.map(assignment, Investigation_Investigation_Inspectors.class);

            return assignmentRepository.save(mappedAssignment);
        }

        public void deleteAssignment(String caseNo) {
            assignmentRepository.deleteById(caseNo);
        }


}
