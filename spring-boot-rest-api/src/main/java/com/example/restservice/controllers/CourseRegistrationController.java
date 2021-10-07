package com.example.restservice.controllers;

import com.example.restservice.models.CourseRegistration;
import com.example.restservice.models.Tutorial;
import com.example.restservice.services.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation/course/registration")
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<CourseRegistration> saveCourseRegistration(@RequestBody CourseRegistration courseRegistration) {

        if(courseRegistration != null){
            return new ResponseEntity<>(
                    courseRegistrationService.createCourseRegistration(courseRegistration),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                HttpStatus.NOT_FOUND
        );
    }

    @GetMapping("/get/all")
    public @ResponseBody ResponseEntity<List<CourseRegistration>> getAllCourseRegistraions() {

        return new ResponseEntity<>(
                courseRegistrationService.getAllCR(),
                HttpStatus.OK
        );

    }

    @GetMapping("/get/{id}")
    public @ResponseBody ResponseEntity<CourseRegistration> findCourseRegistraionById(@PathVariable int id) {
        return new ResponseEntity<>(
                courseRegistrationService.getCRById(id),
                HttpStatus.OK
        );
    }

}
