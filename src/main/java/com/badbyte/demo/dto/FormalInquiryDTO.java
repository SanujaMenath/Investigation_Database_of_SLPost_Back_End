package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormalInquiryDTO {

    @NotNull
        private String id;
    @NotNull
        private String fileId;
        private LocalDate dateOfAppoint;
        private LocalDate startedDate;
        private LocalDate endDate;
        private String recommendationOfIO;
        private LocalDate dateOfRecommendation;

}
