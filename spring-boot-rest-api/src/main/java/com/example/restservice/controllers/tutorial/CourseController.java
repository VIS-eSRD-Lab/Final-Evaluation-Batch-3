package com.example.restservice.controllers.tutorial;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get/all")
    public @ResponseBody ResponseEntity<List<List<String>>> getAllCourse() {

        return new ResponseEntity<>(
                courseService.addCourse(),
                HttpStatus.OK
        );
    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<List<String>> getCourseById(@PathVariable int id) {

        return new ResponseEntity<>(
                courseService.getCourse(id),
                HttpStatus.OK
        );
    }
}
