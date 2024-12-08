package com.badbyte.demo.dto;

import com.badbyte.demo.enums.LocationType;
import com.badbyte.demo.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthenticateUserDTO {

    @NotNull
    private Long id;

    @NotNull
    @Email(message = "Invalid email format")
    private String email;

    @NotNull
    private Role role;

    private LocationType locationType;

    @Min(value = 0, message = "Location ID must be a positive number")
    private Integer locationId;
}
