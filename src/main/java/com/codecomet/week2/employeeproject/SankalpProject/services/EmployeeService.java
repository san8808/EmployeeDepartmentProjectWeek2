package com.codecomet.week2.employeeproject.SankalpProject.services;

import com.codecomet.week2.employeeproject.SankalpProject.dto.EmployeeDTO;
import com.codecomet.week2.employeeproject.SankalpProject.entites.EmployeeEntity;
import com.codecomet.week2.employeeproject.SankalpProject.exceptions.ResourceNotFoundException;
import com.codecomet.week2.employeeproject.SankalpProject.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    public EmployeeDTO getEmployeeById(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> listOfEmployees = employeeRepository.findAll();

        return listOfEmployees.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());
    }


    public EmployeeDTO updateEmployeeById(Long employeeId,EmployeeDTO employeeDTO) {
        isEmployeeExists(employeeId);

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setEmployeeId(employeeId);

        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);

    }

    public boolean deleteEmployeeById(Long employeeId) {

      isEmployeeExists(employeeId);

      employeeRepository.deleteById(employeeId);

      return true;
    }

    public boolean isEmployeeExists(Long employeeId){

        boolean exists =employeeRepository.existsById(employeeId);

        if(!exists) throw new ResourceNotFoundException("Employee not found with id: "+employeeId);

        return true;
    }
}
