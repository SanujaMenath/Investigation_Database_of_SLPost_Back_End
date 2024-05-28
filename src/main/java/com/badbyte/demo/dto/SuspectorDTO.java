package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuspectorDTO {

    @NotNull
    private String nic;

    private String name;

    private LocalDateTime dob;

    private LocalDateTime retiredDate;
}
