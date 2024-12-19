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
public class ChargeSheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID
    private Long id;  // Change the type to Long for auto-generated values

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investigation_id")
    private Investigations investigations;

    private LocalDateTime issuedDate;
    private LocalDateTime dateOfAnswered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "suspector_id")  // Change the column name to use 'suspector_id'
    private Suspectors suspectors;

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
