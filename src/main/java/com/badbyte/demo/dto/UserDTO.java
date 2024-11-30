package com.badbyte.demo.dto;

import com.badbyte.demo.enums.Role;
import com.badbyte.demo.enums.LocationType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "First name must be between 1 and 50 characters")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50, message = "Last name must be between 1 and 50 characters")
    private String lastName;

    @NotNull
    @Email(message = "Invalid email format")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull
    private Role role;

    @NotNull
    private LocationType locationType;

    @NotNull
    @Min(value = 0, message = "Location ID must be a positive number")
    private Integer locationId;
}
