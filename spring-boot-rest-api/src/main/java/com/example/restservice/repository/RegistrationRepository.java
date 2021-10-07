package com.example.restservice.repository;

import com.example.restservice.models.tutorial.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Registration findByStudentIdContaining(Integer studentID);
}
