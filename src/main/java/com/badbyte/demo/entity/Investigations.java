package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Investigations {


    @Id
    private String fileId;

    private String incident;

    private Date incidentDate;

    private Date dateReferedToInvestigate;

    private Date dateOfFinalReportIssued;

    private String recommendationOfFinalReport;

    private String personWhoAcceptedSubmission;

    private Date acceptedSubmissionDate;

    private Date handOveredDateOfSubmission;

    private Integer divisionId;

    private String status;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "investigations", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Investigation_Investigation_Inspectors> assignments = new HashSet<>();


}
