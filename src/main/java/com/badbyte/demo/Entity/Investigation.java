package com.badbyte.demo.Entity;

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
public class Investigation {


    @Id
    private String fileId;

    private String incident;

    private LocalDateTime incidentDate;

    private LocalDateTime dateReferedToInvestigate;

    private LocalDateTime dateOfFinalReportIssued;

    private String recommendationOfFinalReport;

    private String personWhoAcceptedSubmission;

    private LocalDateTime acceptedSubmissionDate;

    private LocalDateTime handOveredDateOfSubmission;

    private boolean status;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "investigation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IIAssignment> assignments = new HashSet<>();

    @OneToMany(mappedBy = "investigation", cascade = CascadeType.ALL)
    private Set<Inv_Suspector> investigationSuspectors ;


}
