package com.example.demo.studentRegistry;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    // It is a dependency injection used to make a connection between this control layer and service layer, that is this studentService is injected with StudentServce class
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/all")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable("id") Long id){
        Optional<Student> studentOpt = studentService.getStudentInfo(id);
        if (studentOpt.isPresent()) {
            return ResponseEntity.ok(studentOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/newuser")
    public ResponseEntity<Student> registerNewStudent(@RequestBody Student student) throws IOException
    {
        Student newUser = studentService.addNewStudent(student);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{Id}") 
    public void removeStudent(@PathVariable("Id") Long Id) throws IOException
    {
            studentService.deleteStudent(Id);
            
    }

    @PutMapping(path = "{userId}")
    public ResponseEntity<String> updateStudent(@PathVariable("userId") Long userId, @RequestParam(required = false) String name, @RequestParam(required = false) String email
                   ,@RequestParam(required = false) String statetname, @RequestParam(required = false) String streetname, @RequestParam(required = false) String zipcode)  throws IOException
    {
        studentService.updateStudentDetails(userId, name, email, statetname, streetname,zipcode);
        return ResponseEntity.ok("Student details updated successfully");
    }

      @GetMapping("/{depname}/students")
    public List<Student> getStudentsByDepartment(@PathVariable String depname){
        return studentService.getStudentsByDept(depname);
    }


}
