package com.example.restservice.repository;

import com.example.restservice.models.tutorial.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

    Registration findByStudentID(Integer studentID);
}
