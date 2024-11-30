package com.badbyte.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Suspectors {
    @Id
    private String nic;

    private String name;

    private LocalDateTime dob;

    private LocalDateTime retiredDate;


}
