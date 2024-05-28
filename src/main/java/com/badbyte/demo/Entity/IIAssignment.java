package com.badbyte.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class IIAssignment {

        @Id
        private String caseNo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "file_id")
        private Investigation investigation;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "nic")
        private InvestigationInspector inspector;

        private String acquiredDate;
        private String submittedDate;
        private String reacquiredDate;
        private String resubmittedDate;




}
