package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Investigation_Investigation_Inspectors {

        @Id
        private String caseNo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "file_id")
        private Investigations investigations;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "nic")
        private Investigation_Inspectors inspector;

        private String acquiredDate;
        private String submittedDate;
        private String reacquiredDate;
        private String resubmittedDate;

}
