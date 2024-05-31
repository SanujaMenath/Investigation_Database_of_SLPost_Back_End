package com.badbyte.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inv_SuspectorDTO {


        private InvestigationRefDTO investigation;
        private SuspectorRefDTO suspector;
        private Date interdictedDate;
        private Date dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private Date dateOfRestateForAppealed;
        private Date restateDate;
        private Date dateOfFinalOrderThatInformedToAccused;


}
