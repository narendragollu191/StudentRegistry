package com.example.demo.studentRegistry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {


    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("/newdept")
    public ResponseEntity<String> addDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
        return ResponseEntity.ok("New Department added");
    }

    @GetMapping("/all")
    public List<Department> getDepartments(){
       return departmentService.getAllDepartments();        
    }

  


}
