package com.example.restservice.controllers;

import com.example.restservice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get/all")
    public @ResponseBody
    ResponseEntity<List<List<String>>> getAllStudent() {

        return new ResponseEntity<>(
                studentService.csvStudent(),
                HttpStatus.OK
        );
    }

     @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<List<String>> getStudentById(@PathVariable int id) {

        return new ResponseEntity<>(
                studentService.getStudent(id),
                HttpStatus.OK
        );
    }
}
