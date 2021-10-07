package com.example.restservice.controllers.tutorial;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/finalevaluation")
public class RegistrationController {

    @Autowired
    private RegistrationService _regService;

    @PostMapping("/reg/create")
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration reg) {
        try {
            return new ResponseEntity<>(_regService.createRegService(reg), HttpStatus.CREATED) ;
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/reg/get/all")
    public ResponseEntity<List<Registration>> getAllReg() {
        try {
            if (_regService.getAllRegService().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(_regService.getAllRegService(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reg/get/{studentID}")
    public ResponseEntity<Registration> getRegById(@PathVariable Integer studentID) {
        try {
            return new ResponseEntity<>(_regService.getRegByIDService(studentID), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
