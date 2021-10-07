package com.example.restservice.controllers.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

import com.example.restservice.models.Student.Student;
import com.example.restservice.repository.StudentRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
    StudentRepository studentRepository;
	
	
	
	//1 | Get course List API

	  @GetMapping("/get/all")
	    public @ResponseBody ResponseEntity<List<CorsRegistration>> getAllCourseRegistraions() {

	        return new ResponseEntity<>(
	                courseRegistrationService.getAllCR(),
	                HttpStatus.OK
	        );
	
	
	
	//2 | Get course by Id API
	        @GetMapping("/get/{id}")
	        public @ResponseBody ResponseEntity<CourseRegistration> findCourseRegistraionById(@PathVariable int id) {
	            return new ResponseEntity<>(
	                    courseRegistrationService.getCRById(id),
	                    HttpStatus.OK
	            );
	        } 
	
	
}