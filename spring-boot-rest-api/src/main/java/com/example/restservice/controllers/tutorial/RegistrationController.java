package com.example.restservice.controllers.tutorial;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finalevaluation")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @PostMapping("/reg/create")
    public Registration add(@RequestBody Registration registration) {
        return registrationService.createRegistration(registration);
    }


    @GetMapping("/reg/get/{id}")
    public Registration findById(@PathVariable int studentID) {
        return registrationService.getById(studentID);
    }


    @GetMapping("/reg/get/all")
    public List<Registration> find() {
        return registrationService.get();
    }
}
