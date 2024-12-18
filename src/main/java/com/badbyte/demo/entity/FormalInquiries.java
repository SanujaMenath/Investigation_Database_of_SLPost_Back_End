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
        private String id; // given by the user

        @ManyToOne
        @JoinColumn(name = "file_id")
        private Investigations investigations;

        private Date dateOfAppoint;
        private Date startedDate;
        private Date endDate;
        private String recommendationOfIO;
        private Date dateOfRecommendation;


}
