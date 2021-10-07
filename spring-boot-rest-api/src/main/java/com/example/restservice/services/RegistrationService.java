package com.example.restservice.services;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration createRegistration(Registration registration) {

        return registrationRepository.save(registration);
    }



    public Registration getById(Integer studentID) {
        return registrationRepository.findById(studentID).orElse(null);
    }

    //Get All
    public List<Registration> get() {
        return registrationRepository.findAll();
    }
}