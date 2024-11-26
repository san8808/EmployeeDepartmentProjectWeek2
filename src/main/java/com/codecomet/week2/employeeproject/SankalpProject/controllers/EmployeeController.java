package com.codecomet.week2.employeeproject.SankalpProject.controllers;

import com.codecomet.week2.employeeproject.SankalpProject.dto.EmployeeDTO;
import com.codecomet.week2.employeeproject.SankalpProject.entites.EmployeeEntity;
import com.codecomet.week2.employeeproject.SankalpProject.exceptions.ResourceNotFoundException;
import com.codecomet.week2.employeeproject.SankalpProject.services.EmployeeService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){

        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);

        if(employeeDTO==null) throw new ResourceNotFoundException("Employee Not found with id: "+employeeId);

        return ResponseEntity.ok(employeeDTO);
    }

    //handling the exceptions locally
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFound(NoSuchElementException exception){
//        return new ResponseEntity<>("Employee Not Found",HttpStatus.NOT_FOUND);
//    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid  EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createNewEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        boolean deleted = employeeService.deleteEmployeeById(employeeId);

        if(deleted) return ResponseEntity.ok(true);

        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
