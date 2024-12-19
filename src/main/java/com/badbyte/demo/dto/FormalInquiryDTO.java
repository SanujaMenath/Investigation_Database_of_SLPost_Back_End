package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormalInquiryDTO {

        @NotNull
        private Long id;

        @NotNull
        private InvestigationRefDTO investigation;

        private LocalDateTime dateOfAppoint;
        private LocalDateTime startedDate;
        private LocalDateTime endDate;
        private String recommendationOfIO;
        private LocalDateTime dateOfRecommendation;
}

