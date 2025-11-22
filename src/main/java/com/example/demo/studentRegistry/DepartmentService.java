package com.example.demo.studentRegistry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public void addNewDepartment(Department department){
        departmentRepository.save(department);       
    }
    

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }


    

}
