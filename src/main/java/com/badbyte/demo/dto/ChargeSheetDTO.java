package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChargeSheetDTO {

    private Long id;

    private InvestigationRefDTO investigation;
    private SuspectorRefDTO suspector;

    private LocalDateTime issuedDate;
    private LocalDateTime dateOfAnswered;

    private LocalDateTime dateOfPersonalFileCalled;
    private LocalDateTime dateOfPersonalReturned;

    private String disciplinaryOrder;

    private LocalDateTime dateOfAppealedForPSC;
    private String pscOrderDescription;
    private LocalDateTime dateOfPSCOrderTaken;
    private LocalDateTime dateOfAppealedToAAT;
    private LocalDateTime dateOfAATOrderTaken;
    private String aatOrderDescription;
}
