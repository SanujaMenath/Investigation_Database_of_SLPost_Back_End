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
public class ChargeSheets {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private Investigations investigations;

    private Date issuedDate;
    private Date dateOfAnswered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nic")
    private Suspectors suspectors;

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
