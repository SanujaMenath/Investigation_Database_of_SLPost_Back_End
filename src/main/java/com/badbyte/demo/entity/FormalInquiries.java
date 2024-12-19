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
public class FormalInquiries {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "investigation_id", nullable = false)
        private Investigations investigations;

        private LocalDateTime dateOfAppoint;
        private LocalDateTime startedDate;
        private LocalDateTime endDate;
        private String recommendationOfIO;
        private LocalDateTime dateOfRecommendation;
}

