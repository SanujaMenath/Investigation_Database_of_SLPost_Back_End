package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InterimReportDTO {

    @NotNull
    private String interimReportId;

    private InvestigationRefDTO investigation;

    private InspectorRefDTO investigationInspector;

    private String interimRecommendation;

    private LocalDateTime dateIssued;
}
