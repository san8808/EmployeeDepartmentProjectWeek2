package com.codecomet.week2.employeeproject.SankalpProject.dto;


import com.codecomet.week2.employeeproject.SankalpProject.annotations.PasswordValidation;
import com.codecomet.week2.employeeproject.SankalpProject.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    Long departmentId;

    @NotEmpty
    String departmentName;

    @NotEmpty
    String location;

    Boolean isActive;

    LocalDate createDt;

    @PrimeNumberValidation
    Integer primeNumber;

    @PasswordValidation
    String password;


}
