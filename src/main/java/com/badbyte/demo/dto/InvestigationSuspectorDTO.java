package com.badbyte.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestigationSuspectorDTO {

        private Long id;

        private Long investigationId; // Reference to the investigation ID
        private Long suspectorId;

        private LocalDateTime interdictedDate;
        private LocalDateTime dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private LocalDateTime dateOfRestateForAppealed;
        private LocalDateTime restateDate;
        private LocalDateTime dateOfFinalOrderThatInformedToAccused;
}

