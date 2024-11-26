package com.codecomet.week2.employeeproject.SankalpProject.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;

    String name;

    String email;

    String phoneNumber;

    Integer age;

    Long creditCardNumber;

    LocalDate dateOfBirth;

    String jobTitle;

    LocalDate createDate;

    @JsonProperty("isActive")
    Boolean isActive;

    String role;

    LocalDate dateOfJoining;

}
