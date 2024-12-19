package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Investigation_Suspectors {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "investigation_id", nullable = false)
        private Investigations investigations;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "suspector_id", nullable = false)
        private Suspectors suspectors;

        private LocalDateTime interdictedDate;
        private LocalDateTime dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private LocalDateTime dateOfRestateForAppealed;
        private LocalDateTime restateDate;
        private LocalDateTime dateOfFinalOrderThatInformedToAccused;

}



