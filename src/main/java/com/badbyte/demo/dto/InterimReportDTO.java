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

    @NotNull
    private String fileId;

    @NotNull
    private String nic;

    private String interimRecommendation;

    private LocalDateTime dateIssued;
}
