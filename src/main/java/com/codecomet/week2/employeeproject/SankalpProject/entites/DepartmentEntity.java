package com.codecomet.week2.employeeproject.SankalpProject.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "department_info")
@Data
@Getter
@Setter
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long departmentId;

    String departmentName;

    String location;

    Boolean isActive;

    LocalDate createDt;

    Integer primeNumber;
}
