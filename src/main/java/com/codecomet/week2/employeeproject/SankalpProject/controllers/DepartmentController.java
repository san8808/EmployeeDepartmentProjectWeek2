package com.codecomet.week2.employeeproject.SankalpProject.controllers;

import com.codecomet.week2.employeeproject.SankalpProject.dto.DepartmentDTO;
import com.codecomet.week2.employeeproject.SankalpProject.dto.EmployeeDTO;
import com.codecomet.week2.employeeproject.SankalpProject.exceptions.ResourceNotFoundException;
import com.codecomet.week2.employeeproject.SankalpProject.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId){
        DepartmentDTO departmentDTO= departmentService.getDepartmentById(departmentId);

        if(departmentDTO==null) throw new ResourceNotFoundException("Department not found with id: "+ departmentId);

        return ResponseEntity.ok(departmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){

        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.createNewDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@PathVariable Long departmentId, @RequestBody DepartmentDTO departmentDTO){

        return new ResponseEntity<>(departmentService.updateDepartmentById(departmentId,departmentDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){

        boolean deleted=departmentService.deleteDepartmentById(departmentId);

        if(deleted) return ResponseEntity.ok(true);

        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }




}
