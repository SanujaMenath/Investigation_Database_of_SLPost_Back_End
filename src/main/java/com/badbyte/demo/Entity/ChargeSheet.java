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
public class ChargeSheet {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private Investigation investigation;

    private Date issuedDate;
    private Date dateOfAnswered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nic")
    private Suspector suspector;

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
