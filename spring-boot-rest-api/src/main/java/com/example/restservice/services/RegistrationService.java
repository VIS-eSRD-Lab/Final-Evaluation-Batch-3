package com.example.restservice.services;

import com.example.restservice.models.tutorial.Registration;
import com.example.restservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository _regRepo;

//    create new registration
    public Registration createRegService(Registration reg) {
        return _regRepo.save(reg);
    }

//    get all registration group by student id
    public List<Registration> getAllRegService() {
        List<Registration> reg =  _regRepo.findAll();

        return null;
    }

//    get all courses and fee by student id
    public Registration getRegByIDService(Integer studentID) {
        Registration registration = _regRepo.findByStudentIdContaining(studentID);
        registration.getCourseName();
        registration.getCourseFee();

        return null;
    }
}
