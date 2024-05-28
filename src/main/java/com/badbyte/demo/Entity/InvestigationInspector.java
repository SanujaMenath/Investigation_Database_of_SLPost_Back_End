package com.badbyte.demo.Entity;

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
public class InvestigationInspector {

    @Id
    private String nic;

    private String name;

    @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IIAssignment> assignments = new HashSet<>();
}
