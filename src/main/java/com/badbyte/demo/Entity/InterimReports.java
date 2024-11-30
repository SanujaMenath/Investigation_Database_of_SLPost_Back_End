package com.badbyte.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class InterimReports {
    @Id
    private String interimReportId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private Investigations investigations;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "nic")
    private Investigation_Inspectors investigationInspectors;

    private String interimRecommendation;

    private LocalDateTime dateIssued;
    


}
