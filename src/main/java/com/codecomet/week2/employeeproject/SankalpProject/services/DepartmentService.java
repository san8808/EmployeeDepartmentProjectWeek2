package com.codecomet.week2.employeeproject.SankalpProject.services;

import com.codecomet.week2.employeeproject.SankalpProject.dto.DepartmentDTO;
import com.codecomet.week2.employeeproject.SankalpProject.entites.DepartmentEntity;
import com.codecomet.week2.employeeproject.SankalpProject.exceptions.ResourceNotFoundException;
import com.codecomet.week2.employeeproject.SankalpProject.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    public DepartmentDTO getDepartmentById(Long departmentId){
        return modelMapper.map(departmentRepository.findById(departmentId),DepartmentDTO.class);
    }

    public List<DepartmentDTO> getAllDepartment(){
        List<DepartmentEntity> departments = departmentRepository.findAll();

        return departments.stream().map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class)).toList();
    }

    public DepartmentDTO createNewDepartment(DepartmentDTO departmentDTO){
        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);

        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO departmentDTO){

        isDepartmentExists(departmentId);

        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setDepartmentId(departmentId);

        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long departmentId){
        isDepartmentExists(departmentId);
        try {
            departmentRepository.deleteById(departmentId);
            return true;
        }
        catch(Exception e) {
            return false;
        }

    }

    public boolean isDepartmentExists(Long departmentId){

        boolean isExists = departmentRepository.existsById(departmentId);

        if(!isExists) throw new ResourceNotFoundException("Department not found");

        return true;
    }

}
