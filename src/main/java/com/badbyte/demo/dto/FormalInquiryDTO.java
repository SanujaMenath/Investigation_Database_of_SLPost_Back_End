package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormalInquiryDTO {

        @NotNull
        private String id;

        private InvestigationRefDTO investigation;
        private Date dateOfAppoint;
        private Date startedDate;
        private Date endDate;
        private String recommendationOfIO;
        private Date dateOfRecommendation;

}
