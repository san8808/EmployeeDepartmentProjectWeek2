package com.codecomet.week2.employeeproject.SankalpProject.repositories;

import com.codecomet.week2.employeeproject.SankalpProject.entites.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
