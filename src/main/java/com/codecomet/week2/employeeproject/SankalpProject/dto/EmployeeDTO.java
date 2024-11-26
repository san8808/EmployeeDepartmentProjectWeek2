package com.codecomet.week2.employeeproject.SankalpProject.dto;

import com.codecomet.week2.employeeproject.SankalpProject.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    Long employeeId;

    @NotBlank(message = "Please enter a valid name.")
    @Size(min = 1,max=10,message = "Name cannot be greater than 10 characters")
    String name;

    @Email
    String email;

    @Pattern(regexp = "\\d{10}" , message = "Phone Number must have exactly 10 digits ")
    String phoneNumber;

    @Min(value = 18,message = "Age of employee cannot be less than 18.")
    @Max(value = 90, message = "Age of employee cannot be greater than 90")
    @NotNull
    Integer age;

    Long creditCardNumber;

    @PastOrPresent
    LocalDate dateOfBirth;


    @NotEmpty
    String jobTitle;


    LocalDate createDate;


    Boolean isActive;

    @EmployeeRoleValidation
    String role;

    LocalDate dateOfJoining;

}
