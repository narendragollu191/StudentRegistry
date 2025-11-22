package com.example.demo.studentRegistry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findStudentById(Long Id);

    List<Student> findByDepartment_Depname(String depname);


}
