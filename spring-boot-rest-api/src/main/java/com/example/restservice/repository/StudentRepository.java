package com.example.restservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.models.Student.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //List<Student> findByReg_id(long reg_id);
    List<Student> findByFirstnameContaining(String firstname);
    //List<Student> findAll();
    //void deleteAll();
    //List<Student> deleteByReg_id(long reg_id);
    //List<Student> save();

    
}