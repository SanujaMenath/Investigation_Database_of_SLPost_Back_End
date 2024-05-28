package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inv_SuspectorDTO {



        private Date interdictedDate;
        private Date dateOfAppealedForReinstate;
        private Boolean appealedAcceptedOrRejected;
        private Date dateOfRestateForAppealed;
        private Date restateDate;
        private Date dateOfFinalOrderThatInformedToAccused;


}
