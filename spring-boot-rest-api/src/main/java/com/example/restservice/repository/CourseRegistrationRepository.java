package com.example.restservice.repository;

import com.example.restservice.models.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Integer> {
}
