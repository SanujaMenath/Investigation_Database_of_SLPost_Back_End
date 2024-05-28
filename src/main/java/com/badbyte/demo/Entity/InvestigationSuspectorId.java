package com.badbyte.demo.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
    @AllArgsConstructor
    @Data

    @Embeddable
    public class InvestigationSuspectorId implements Serializable {
        private String fileId;
        private String NIC;


    }
