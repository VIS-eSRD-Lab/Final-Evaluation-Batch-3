package com.example.restservice.controllers.tutorial;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation")
public class StudentController {

    private StudentService studentService;

    @GetMapping("/get/all")
    public @ResponseBody
    ResponseEntity<List<List<String>>> getAllStudent() {

        return new ResponseEntity<>(
                studentService.AddStudent(),
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
