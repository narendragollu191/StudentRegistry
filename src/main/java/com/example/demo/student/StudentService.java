package com.example.demo.student;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.imageio.IIOException;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
// this class has to be instanistated, i.e a spring bean, StudentService
// specified in control class can be able to identify this class through this
// @Servive or @Component anotations
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Student addNewStudent(Student student) throws IOException {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IIOException("email present");
    }

    studentRepository.save(student);
    return student;
  }

  public void deleteStudent(Long Id) throws IOException {
    Boolean exists = studentRepository.existsById(Id);
    if (!exists) {
      throw new IIOException("Student with Id " + Id + "doesn't exist");
    }
    studentRepository.deleteById(Id);

  }

  @Transactional
  public void updateStudentDetails(Long userId, String name, String email) throws IOException {
    Student student = studentRepository.findById(userId)
    .orElseThrow(() -> new IIOException("student with Id " + userId + " does not exist"));

    if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }

    if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
        System.out.println(student.getEmail());
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
      if (studentOptional.isPresent()) {
        throw new IIOException("email present");
      }
      student.setEmail(email);
    }
  }

}
