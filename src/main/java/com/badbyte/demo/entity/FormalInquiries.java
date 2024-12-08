package com.badbyte.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class FormalInquiries {


        @Id
        private String id; // given by the user

        @ManyToOne
        @JoinColumn(name = "file_id")
        private Investigations investigations;

        private LocalDate dateOfAppoint;
        private LocalDate startedDate;
        private LocalDate endDate;
        private String recommendationOfIO;
        private LocalDate dateOfRecommendation;


}
