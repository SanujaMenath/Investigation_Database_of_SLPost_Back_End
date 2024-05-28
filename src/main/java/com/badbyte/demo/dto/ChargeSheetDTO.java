package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargeSheetDTO {

    @NotNull
    private String id;

    private InvestigationRefDTO investigation;
    private SuspectorRefDTO suspector;

    private Date issuedDate;
    private Date dateOfAnswered;

    private Date dateOfPersonalFileCalled;
    private Date dateOfPersonalReturned;

    //there is a doubt to clear
    private String disciplinaryOrder;

    private Date dateOfAppealedForPSC;
    private String pscOrderDescription;
    private Date dateOfPSCOrderTaken;
    private Date dateOfAppealedToAAT;
    private Date dateOfAATOrderTaken;
    //doubt
    private String aatOrderDescription;
}
