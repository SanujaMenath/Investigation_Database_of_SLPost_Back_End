package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Investigation_Suspectors {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne (fetch = FetchType.LAZY)
        @JoinColumn(name = "fileId")
        private Investigations investigations;

        @ManyToOne (fetch = FetchType.LAZY)
        @JoinColumn(name = "nic")
        private Suspectors suspectors;

        private Date interdictedDate;
        private Date dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private Date dateOfRestateForAppealed;
        private Date restateDate;
        private Date dateOfFinalOrderThatInformedToAccused;


    }


