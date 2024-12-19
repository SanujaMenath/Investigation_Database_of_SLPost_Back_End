package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Investigations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileId;

    private String incident;

    private LocalDateTime incidentDate;

    private LocalDateTime dateReferredToInvestigate;

    private LocalDateTime dateOfFinalReportIssued;

    private String recommendationOfFinalReport;

    private String personWhoAcceptedSubmission;

    private LocalDateTime acceptedSubmissionDate;

    private LocalDateTime handOveredDateOfSubmission;

    private Integer divisionId;

    private String status;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // One-to-many relationship with Investigation_Investigation_Inspectors
    @OneToMany(mappedBy = "investigations", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Investigation_Investigation_Inspectors> assignments = new HashSet<>();

}
