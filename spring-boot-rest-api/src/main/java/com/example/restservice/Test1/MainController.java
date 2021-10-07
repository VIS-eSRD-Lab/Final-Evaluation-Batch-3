package com.example.restservice.Test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

//    @GetMapping("student/get/all")
//    public List<Student> getAllStudents(){
//        return mainService.allStudents();
//    }
//
//    @GetMapping("student/get/{id}")
//    public Student findStudentById(@PathVariable("id") int id){
//        return mainService.findStudentById(id);
//    }
}
