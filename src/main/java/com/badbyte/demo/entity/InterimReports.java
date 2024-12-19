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
public class InterimReports {

    @Id
    private String interimReportId;

    // Foreign key reference to Investigations entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investigation_id", nullable = false)
    private Investigations investigations;

    // Foreign key reference to Investigation_Inspectors entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nic", nullable = false)
    private Investigation_Inspectors investigationInspectors;

    private String interimRecommendation;

    private LocalDateTime dateIssued;
}
