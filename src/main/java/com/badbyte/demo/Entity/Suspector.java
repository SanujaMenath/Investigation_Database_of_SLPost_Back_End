package com.badbyte.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Suspector {
    @Id
    private String nic;

    private String name;

    private LocalDateTime dob;

    private LocalDateTime retiredDate;

    @OneToMany(mappedBy = "suspect", cascade = CascadeType.ALL)
    private Set<Inv_Suspector> investigationSuspectors ;
}
