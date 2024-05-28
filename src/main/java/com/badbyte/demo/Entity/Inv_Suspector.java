package com.badbyte.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Inv_Suspector {


        @EmbeddedId
        private InvestigationSuspectorId id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "fileId")
        private Investigation investigation;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "nic")
        private Suspector suspect;

        private Date interdictedDate;
        private Date dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private Date dateOfRestateForAppealed;
        private Date restateDate;
        private Date dateOfFinalOrderThatInformedToAccused;


    }


