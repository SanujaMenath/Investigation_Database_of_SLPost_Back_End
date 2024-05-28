package com.badbyte.demo.services;

import com.badbyte.demo.Entity.IIAssignment;
import com.badbyte.demo.dto.IIAssignmentDTO;
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

        public List<IIAssignment> getAllAssignments() {
            return assignmentRepository.findAll();
        }

        public IIAssignment getAssignmentById(String caseNo) {
            return assignmentRepository.findById(caseNo).orElse(null);
        }

        public IIAssignment saveAssignment(IIAssignmentDTO assignment) {
            IIAssignment mappedAssignment = modelMapper.map(assignment, IIAssignment.class);

            return assignmentRepository.save(mappedAssignment);
        }

        public void deleteAssignment(String caseNo) {
            assignmentRepository.deleteById(caseNo);
        }


}
