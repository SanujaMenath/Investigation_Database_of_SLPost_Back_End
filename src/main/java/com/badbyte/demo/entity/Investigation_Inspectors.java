package com.badbyte.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Investigation_Inspectors {

    @Id
    private String nic;

    private String name;

    @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Investigation_Investigation_Inspectors> assignments = new HashSet<>();
}
