package com.example.restservice.services;

import com.example.restservice.models.CourseRegistration;
import com.example.restservice.repository.CourseRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;
    public CourseRegistration createCourseRegistration(CourseRegistration courseRegistration) {
        return courseRegistrationRepository.save(courseRegistration);
    }
}
